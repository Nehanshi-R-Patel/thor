package com.xworkz.cm.service;

import org.springframework.ui.Model;

import com.xworkz.cm.dto.ForgotPswDTO;

public interface ForgotPswService {
	String validateEmail(ForgotPswDTO forgotPswDTO,Model model);
}
