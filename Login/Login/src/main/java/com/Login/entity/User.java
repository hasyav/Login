package com.Login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="userId",unique=true)
	@Email
	private String email;	
	
	@NotBlank
	@Size(min=2, message=" First Name should have atleast 2 characters")
	@Column(name="firstname")
	private String firstName;
	
	@NotBlank
	@Size(min=2, message=" Last Name should have atleast 2 characters")
	@Column(name="lastname")
	private String lastName;
	
	
	@NotBlank
	@Column(name="password")
	private String password;
	
	@NotBlank
	@Column(name="cpassword")
	private String cpassword;
	@NotBlank
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	public User() {
		
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User(String email,String firstName, String lastName,  String password, String cpassword, String phoneNumber 
			) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.password = password;
		this.cpassword = cpassword;
		this.phoneNumber = phoneNumber;
	}

	
}
