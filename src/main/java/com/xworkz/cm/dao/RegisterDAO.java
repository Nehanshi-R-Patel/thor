package com.xworkz.cm.dao;

import com.xworkz.cm.entity.RegisterEntity;

public interface RegisterDAO {
	void saveRegisterData(RegisterEntity entity);
	
	boolean getUserId(String userId);
	
	boolean getEmail(String emailId);

}
