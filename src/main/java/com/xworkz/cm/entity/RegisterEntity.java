package com.xworkz.cm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

@Entity
@Table(name="register_table")
public class RegisterEntity implements Serializable {
	
	private static final long serialVersionUID = -2999313019710894632L;

	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator="ref")
	@Column(name="ID")
	private int id;
	
	@NotNull(message="Email can't be null")
	@NotEmpty(message="UserId is required")
	@Column(name="USER_ID")
	private String userId;
	
	@NotNull(message="Email can't be null")
	@NotEmpty(message="Email is required")
	@Column(name="USER_EMAIL")
	private String email;
	
	@Column(name="PHONE_NO")
	private long phoneNo;
	
	@Column(name="INTERESTED_COURSE")
	private String course;
	
	@Column(name="USER_AGREE")
	private String agree;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="COUNT")
	private int count;
	
	public RegisterEntity() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
}
