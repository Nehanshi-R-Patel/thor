package com.xworkz.cm.dao;

import com.xworkz.cm.entity.RegisterEntity;

public interface ForgotPswDAO {
	RegisterEntity fetchEmailId(String mailId);
	
	int updatePassword(String password,int count,int id);
}
