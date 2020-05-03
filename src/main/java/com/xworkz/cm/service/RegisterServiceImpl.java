package com.xworkz.cm.service;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.cm.dao.RegisterDAO;
import com.xworkz.cm.dto.RegisterDTO;
import com.xworkz.cm.entity.RegisterEntity;
import com.xworkz.cm.exception.ServiceException;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	private static final Logger logger=Logger.getLogger(RegisterServiceImpl.class);

	@Autowired
	private RegisterDAO registerDAO;

	public RegisterServiceImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public String validateAndSave(RegisterDTO registerDTO, Model model) throws ServiceException {
		logger.info("invoking validate and save....");
		
		String agreeButton=registerDTO.getAgree();
		logger.info("Agree Button Value: "+agreeButton);
		
		if (!"Agree".equals(agreeButton)) {
			logger.info("Not valid for registration");
			model.addAttribute("msgForDisAgree", "you have disagreed for registration");
			return "Register";
		} 
		else {
			try {
				RegisterEntity entity = new RegisterEntity();
				BeanUtils.copyProperties(registerDTO, entity);
				
				if (registerDAO.getUserId(registerDTO.getUserId()) && registerDAO.getEmail(registerDTO.getEmail())) {
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
			
					logger.info("Encoded Password: "+hashedPassword);
					logger.info("Password Generated");
			
					entity.setPassword(hashedPassword);
					entity.setCount(0);
			
					logger.info("Password :" + psw);
			
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
			}catch (Exception e) {
				ServiceException exception=new ServiceException();
				logger.error(exception.getMessage(),exception);
				throw exception;
			}
		}
	}
}