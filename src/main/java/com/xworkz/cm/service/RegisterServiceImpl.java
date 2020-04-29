package com.xworkz.cm.service;

import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.cm.dao.RegisterDAO;
import com.xworkz.cm.dto.RegisterDTO;
import com.xworkz.cm.entity.RegisterEntity;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO registerDAO;
	
	public RegisterServiceImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public String validateAndSave(RegisterDTO registerDTO, Model model) {
		System.out.println("invoking validate and save....");
		RegisterEntity entity = new RegisterEntity();
		BeanUtils.copyProperties(registerDTO, entity);

		if (registerDTO.getAgree().equals("Dis-agree")) {
			System.out.println("Not valid for registration");
			model.addAttribute("msgForDisAgree", "you have disagreed for registration");
			return "Register";
		}else if (registerDAO.getUserId(registerDTO.getUserId()) && registerDAO.getEmail(registerDTO.getEmail())) {
			String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			String psw = "";
			int length = 8;

			Random random = new Random();
			char[] text = new char[length];
			for (int i = 0; i < length; i++) {
				text[i] = chars.charAt(random.nextInt(chars.length()));
			}
			for (int i = 0; i < length; i++) {
				psw += text[i];
			}
			BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
			String hashedPassword=passwordEncoder.encode(psw);
			
			System.out.println("Encoded Password: "+hashedPassword);
			System.out.println("Password Generated");
			
			entity.setPassword(hashedPassword);
			entity.setCount(0);
			
			System.out.println("Password :" + psw);
			
			model.addAttribute("UserID", entity.getUserId());
			model.addAttribute("Password",psw);
			this.registerDAO.saveRegisterData(entity);
			return "Register";
		} else if (registerDAO.getUserId(registerDTO.getUserId())) {
			model.addAttribute("existingEmail", "Email is already exists");
			return "Register";
		} else {
			model.addAttribute("existingUser", "UserId is already exists");
			return "Register";
		}
	}
}
