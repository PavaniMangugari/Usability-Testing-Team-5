package com.FDB.EShop.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class User {

	
	
	@Id
	private String emailId;
	
	private String password;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	
	
	
	public User()
	{
		
	}
	
	
	
	public User(String emailId, String password, String lastName, String firstName, String phoneNumber
			) {
		super();
		
		this.emailId = emailId;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
	
	}



	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String i) {
		this.phoneNumber = i;
	}
	
	


}
