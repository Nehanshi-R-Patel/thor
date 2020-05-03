package com.xworkz.cm.controller;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.cm.dto.RegisterDTO;
import com.xworkz.cm.exception.ControllerException;
import com.xworkz.cm.service.RegisterService;

@Controller
@RequestMapping("/")
public class RegisterController {

	private static final Logger logger = Logger.getLogger(RegisterController.class);

	@Autowired
	private RegisterService service;

	public RegisterController() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("register.do")
	public String onRegister(RegisterDTO registerDTO, Model model) throws ControllerException {
		String page = "";
		logger.info("Inside onRegister()...");
		logger.info("Model Attribute :" + registerDTO);

		try {
			String result = this.service.validateAndSave(registerDTO, model);
			if (Objects.nonNull(result)) {
				logger.info("Result :" + result);
			}
			page = "Register";
		} catch (Exception e) {
			ControllerException exception = new ControllerException();
			logger.error(exception.getMessage(), exception);
			throw exception;
		}

		return page;
	}
}
