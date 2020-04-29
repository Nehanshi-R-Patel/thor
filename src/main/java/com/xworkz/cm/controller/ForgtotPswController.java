package com.xworkz.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.cm.dto.ForgotPswDTO;
import com.xworkz.cm.service.ForgotPswService;

@Controller
@RequestMapping("/")
public class ForgtotPswController {
	
	@Autowired
	ForgotPswService forgotPswService;
	
	public ForgtotPswController() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping("forgotPsw.do")
	public String onForgot(ForgotPswDTO forgotPswDTO,Model model) {
		System.out.println("Invoking on Forgot...");
		String page=" ";
		
		String mailId=forgotPswDTO.getEmail();
		System.out.println("MailId: "+mailId);
		
		try {
			String dataFmDB=this.forgotPswService.validateEmail(forgotPswDTO,model);
			System.out.println("Data From DB:"+dataFmDB);
			
			if(dataFmDB.equals("emailMatching")) {
				model.addAttribute("EmailMsg", "Match Email....");
				page="ForgotPassword";
			}else {
				model.addAttribute("EmailMsg", "Email is not exist....");
				page="ForgotPassword";
			}
		} catch (Exception e) {
			System.out.println("Exception Found");
			e.printStackTrace();
		}
		return page;
	}
}
