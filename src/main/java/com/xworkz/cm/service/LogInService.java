package com.xworkz.cm.service;

import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.exception.DAOException;
import com.xworkz.cm.exception.ServiceException;

public interface LogInService {
	String validateLogin(LoginDTO loginDTO) throws ServiceException, DAOException;
}
