package com.xworkz.cm.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class RegisterDTO implements Serializable {
	
	private static final long serialVersionUID = -8678379596825896903L;
	
	private static final Logger logger=Logger.getLogger(RegisterDTO.class);
	
	private int id;
	private String userId;
	private String email;
	private long phoneNo;
	private String course;
	private String agree;
	private String password;
	private int count;
	
	public RegisterDTO() {
		logger.info("Created \t"+this.getClass().getSimpleName());
	}
}
