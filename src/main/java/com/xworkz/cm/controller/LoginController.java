package com.xworkz.cm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.exception.ControllerException;
import com.xworkz.cm.service.LogInService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	private static final Logger logger=Logger.getLogger(LoginController.class);
	
	@Autowired
	private LogInService logInService;
	
	public LoginController() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}
	
	@RequestMapping("login.do")
	public String onLogin(LoginDTO loginDTO,Model model) throws ControllerException{
		String page = "";
		logger.info("invoking on login...");
		
		String mailId=loginDTO.getEmail();
		logger.info("Login MailId :"+mailId);
		
		logger.info("----------------");
		
		String pwd=loginDTO.getPassword();
		logger.info("Login Password :"+pwd);
		
		try {
			String  datafmDB=this.logInService.validateLogin(loginDTO);
			logger.info("Data From DB:"+datafmDB);
			
			if(datafmDB.equals("loginSuccess")) {
				logger.info("SignIn Successful");
				model.addAttribute("LoginMsg", "SignIn Successful");
				page= "Home";
			}else if (datafmDB.equals("loginFailed")){
				logger.info("Email or Password is wrong");
				System.out.println("Email or password is wrong");
				model.addAttribute("LoginMsg", "Email or password is wrong");
				page ="Login";
			}
			else {
				logger.info("Your Account has been block due to wrong password");
				model.addAttribute("BlockLogin", "Your Account has been block due to wrong password");
				page ="LoginBlock";
			}
		}catch (Exception e) {
			ControllerException exception=new ControllerException();
			logger.error(exception.getMessage(),e);
			throw exception;
		}
		return page;
	}
}
