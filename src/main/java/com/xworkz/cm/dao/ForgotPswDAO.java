package com.xworkz.cm.dao;

import com.xworkz.cm.entity.RegisterEntity;
import com.xworkz.cm.exception.DAOException;

public interface ForgotPswDAO {
	RegisterEntity fetchEmailId(String mailId) throws DAOException;
	
	int updatePassword(String password,int count,int id) throws DAOException;
}
