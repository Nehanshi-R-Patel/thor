package com.xworkz.cm.service;

import java.util.Objects;
import java.util.Random;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.cm.dao.ForgotPswDAO;
import com.xworkz.cm.dto.ForgotPswDTO;
import com.xworkz.cm.entity.RegisterEntity;

@Service
public class ForgotPswServiceImpl implements ForgotPswService {

	@Autowired
	ForgotPswDAO forgotPswDAO;

	public ForgotPswServiceImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public String validateEmail(ForgotPswDTO forgotPswDTO,Model model) {
		System.out.println("Invoking Validate Email...");
		try {
			RegisterEntity registerEntity = this.forgotPswDAO.fetchEmailId(forgotPswDTO.getEmail());
			System.out.println("Register Entity:" + registerEntity);

			if (Objects.isNull(registerEntity)) {
				return "emailNotMatching";
			}
			int idFmDB = registerEntity.getId();
			System.out.println("Id From DB:" + idFmDB);
			int count = 0;
			if (Objects.nonNull(registerEntity)) {
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
				
				System.out.println("Password Generated :" + psw);
				System.out.println("Encoded Password : "+hashedPassword);
				
				registerEntity.setPassword(hashedPassword);
				registerEntity.setCount(count);
				System.out.println("Count is:"+count);
	
				this.forgotPswDAO.updatePassword(hashedPassword, count, idFmDB);
				model.addAttribute("NewPassword",psw);
				return "emailMatching";
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return "emailNotMatching";
	}
}
