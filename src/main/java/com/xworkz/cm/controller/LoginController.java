package com.xworkz.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.service.LogInService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private LogInService logInService;
	
	public LoginController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}
	
	@RequestMapping("login.do")
	public String onLogin(LoginDTO loginDTO,Model model) {
		String page = "";
		System.out.println("invoking on login...");
		
		String mailId=loginDTO.getEmail();
 		System.out.println("Login MailId :"+mailId);
		
		System.out.println("----------------");
		
		String pwd=loginDTO.getPassword();
		System.out.println("Login Password :"+pwd);
		
		try {
			String  datafmDB=this.logInService.validateLogin(loginDTO);
			System.out.println("Data From DB:"+datafmDB);
			
			if(datafmDB.equals("loginSuccess")) {
				model.addAttribute("LoginMsg", "SignIn Successful");
				page= "Home";
			}else if (datafmDB.equals("loginFailed")){
				System.out.println("Email or password is wrong");
				model.addAttribute("LoginMsg", "Email or password is wrong");
				page ="Login";
			}
			else {
				System.out.println("Your Account has been block due to wrong password");
				model.addAttribute("BlockLogin", "Your Account has been block due to wrong password");
				page ="LoginBlock";
			}
		}catch (Exception e) {
			System.out.println("Exception Found");
			e.printStackTrace();
		}
		return page;
	}
}
