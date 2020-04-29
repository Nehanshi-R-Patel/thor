package com.xworkz.cm.service;

import java.util.Objects;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.cm.dao.LoginDAO;
import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.entity.RegisterEntity;

@Service
public class LoginServiceImpl implements LogInService {
	
	public static int countPasswordAttempt;

	@Autowired
	private LoginDAO loginDAO;

	public LoginServiceImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public String validateLogin(LoginDTO loginDTO) {
		System.out.println("Invoking Validate Login...");
		boolean flag=false;
		try {
			
			RegisterEntity registerEntity=this.loginDAO.fetchEmail(loginDTO.getEmail());
			System.out.println("RegisterEntity :"+registerEntity);
			if(Objects.isNull(registerEntity)) {
				return "loginFailed";
			}
			
			String pswFmDB=registerEntity.getPassword();
			System.out.println("Password From DB :"+pswFmDB);
			
			int idFmDB=registerEntity.getId();
			System.out.println("ID from DB :"+idFmDB);
			
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			boolean isPasswordMatch=encoder.matches(loginDTO.getPassword(),pswFmDB);
			System.out.println("Is Password match: "+isPasswordMatch);
			
			countPasswordAttempt = registerEntity.getCount();
			System.out.println("Count Password Attempt :"+countPasswordAttempt);
			
			if(countPasswordAttempt>=0 && countPasswordAttempt<3) {
				if(isPasswordMatch==true) {
					System.out.println("Password is match...");
					flag=true;
				} else {
					countPasswordAttempt++;
					System.out.println("Count Password: "+countPasswordAttempt);
					System.out.println("password is faild");
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
			e.printStackTrace();
		}
		return "loginFailed";
	}
}
