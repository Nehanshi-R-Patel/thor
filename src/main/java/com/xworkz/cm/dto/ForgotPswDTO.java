package com.xworkz.cm.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ForgotPswDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="Email can't be null")
	@NotEmpty(message="Email is required")
	@Email(message="Enter valid Email id")
	private String email;
	
	public ForgotPswDTO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
}
