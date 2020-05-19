package com.xworkz.cm.service;

import com.xworkz.cm.dto.ForgotPswDTO;
import com.xworkz.cm.exception.DAOException;
import com.xworkz.cm.exception.ServiceException;

public interface ForgotPswService {
	String validateEmail(ForgotPswDTO forgotPswDTO) throws ServiceException, DAOException;
}
