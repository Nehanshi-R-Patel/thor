package com.xworkz.cm.service;

import org.springframework.ui.Model;

import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.dto.RegisterDTO;

public interface RegisterService {
	String validateAndSave(RegisterDTO registerDTO,Model model);
}
