package com.xworkz.cm.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.cm.dao.LoginDAO;
import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.entity.RegisterEntity;
import com.xworkz.cm.exception.DAOException;
import com.xworkz.cm.exception.ServiceException;

@Service
public class LoginServiceImpl implements LogInService {
	
	public static int countPasswordAttempt;
	
	private static final Logger logger=Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private LoginDAO loginDAO;

	public LoginServiceImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public String validateLogin(LoginDTO loginDTO) throws ServiceException, DAOException {
		logger.info("Invoking Validate Login...");
		boolean flag=false;
		try {
			
			RegisterEntity registerEntity=this.loginDAO.fetchEmail(loginDTO.getEmail());
			System.out.println("RegisterEntity :"+registerEntity);
			if(Objects.isNull(registerEntity)) {
				return "loginFailed";
			}
			
			String pswFmDB=registerEntity.getPassword();
			logger.info("Password From DB :"+pswFmDB);
			
			int idFmDB=registerEntity.getId();
			logger.info("ID from DB :"+idFmDB);
			
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			boolean isPasswordMatch=encoder.matches(loginDTO.getPassword(),pswFmDB);
			logger.info("Is Password match: "+isPasswordMatch);
			
			countPasswordAttempt = registerEntity.getCount();
			logger.info("Count Password Attempt :"+countPasswordAttempt);
			
			if(countPasswordAttempt>=0 && countPasswordAttempt<3) {
				if(isPasswordMatch==true) {
					logger.info("Password is match...");
					flag=true;
				} else {
					countPasswordAttempt++;
					logger.info("Count Password: "+countPasswordAttempt);
					logger.info("password is faild");
					this.loginDAO.updateCount(countPasswordAttempt, idFmDB);
				}
			} else { 
				if(countPasswordAttempt==3) {
					return "blockLogin";
				}
			}
			if(flag==true) {
				return "loginSuccess";
			}
		} catch (HibernateException e) {
			ServiceException exception=new ServiceException();
			logger.error(exception.getMessage(),exception);
			throw exception;
		}
		return "loginFailed";
	}
}
