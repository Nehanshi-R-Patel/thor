package com.xworkz.cm.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class RegisterDTO implements Serializable {
	
	private static final long serialVersionUID = -8678379596825896903L;
	
	private int id;
	private String userId;
	private String email;
	private long phoneNo;
	private String course;
	private String agree;
	private String password;
	private int count;
	
	public RegisterDTO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
}
