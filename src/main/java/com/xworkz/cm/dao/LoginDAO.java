package com.xworkz.cm.dao;

import com.xworkz.cm.entity.RegisterEntity;

public interface LoginDAO {
	RegisterEntity fetchEmail(String mail);
	
	int updateCount(int count,int id);
}
