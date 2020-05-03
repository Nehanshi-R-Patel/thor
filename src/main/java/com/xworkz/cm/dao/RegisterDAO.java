package com.xworkz.cm.dao;

import com.xworkz.cm.entity.RegisterEntity;
import com.xworkz.cm.exception.DAOException;

public interface RegisterDAO {
	void saveRegisterData(RegisterEntity entity) throws DAOException;
	
	boolean getUserId(String userId) throws DAOException;
	
	boolean getEmail(String emailId) throws DAOException;

}
