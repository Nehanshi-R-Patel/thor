package com.xworkz.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.cm.dto.RegisterDTO;
import com.xworkz.cm.service.RegisterService;

@Controller
@RequestMapping("/")
public class RegisterController {
	
	@Autowired
	private RegisterService service;
	
	public RegisterController() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping("register.do")
	public String onRegister(RegisterDTO registerDTO,Model model) {
		System.out.println("invoking on register...");
		System.out.println("Model Attribute :"+registerDTO);
		this.service.validateAndSave(registerDTO,model);
	
		return "Register";
	}
}
