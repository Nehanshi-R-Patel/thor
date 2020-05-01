package com.xworkz.cm.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ForgotPswDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger=Logger.getLogger(ForgotPswDTO.class);
	
	@NotNull(message="Email can't be null")
	@NotEmpty(message="Email is required")
	@Email(message="Enter valid Email id")
	private String email;
	
	public ForgotPswDTO() {
		logger.info("Created \t"+this.getClass().getSimpleName());
	}
}
