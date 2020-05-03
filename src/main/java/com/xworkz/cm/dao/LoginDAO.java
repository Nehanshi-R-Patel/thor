package com.xworkz.cm.dao;

import com.xworkz.cm.entity.RegisterEntity;
import com.xworkz.cm.exception.DAOException;

public interface LoginDAO {
	RegisterEntity fetchEmail(String mail) throws DAOException;
	
	int updateCount(int count,int id) throws DAOException;
}
