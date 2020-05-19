package com.xworkz.cm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.cm.dto.ForgotPswDTO;
import com.xworkz.cm.exception.ControllerException;
import com.xworkz.cm.service.ForgotPswService;

@Controller
@RequestMapping("/")
public class ForgtotPswController {
	
	private static final Logger logger=Logger.getLogger(ForgtotPswController.class);
	
	@Autowired
	ForgotPswService forgotPswService;
	
	public ForgtotPswController() {
		logger.info("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping("forgotPsw.do")
	public String onForgot(ForgotPswDTO forgotPswDTO,Model model) throws ControllerException {
		logger.info("Invoking on Forgot...");
		String page=" ";
		
		String mailId=forgotPswDTO.getEmail();
		logger.info("MailId: "+mailId);
		
		try {
			String dataFmDB=this.forgotPswService.validateEmail(forgotPswDTO);
			logger.info("Data From DB:"+dataFmDB);
			
			if(dataFmDB.equals("emailMatching")) {
				logger.info("Email is match");
				model.addAttribute("EmailMsg", "Match Email....");
				page="ForgotPassword";
			}else {
				logger.info("Email is not Exist...!");
				model.addAttribute("EmailMsg", "Email is not Exist...!");
				page="ForgotPassword";
			}
		} catch (Exception e) {
			ControllerException exception=new ControllerException();
			logger.error(exception.getMessage(),e);
			throw exception;
		}
		return page;
	}
}
