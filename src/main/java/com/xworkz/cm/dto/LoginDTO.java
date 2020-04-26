package com.xworkz.cm.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class LoginDTO implements  Serializable{
	
	private static final long serialVersionUID = 3237461179262081677L;

	@NotNull(message="Email can't be null")
	@NotEmpty(message="Email is required")
	@Email(message="Enter valid Email id")
	private String email;
	
	@NotNull(message="Password can't be null")
	@NotEmpty(message="Password is required")
	@Size(message="Password must be contain 8 characters")
	private String password;
	
	public LoginDTO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
}
