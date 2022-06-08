package com.FDB.EShop.model;

public class EntireUser {

private String emailId;
	
	private String password;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String houseNumber;
	private String streetName;
	private String city;
	private String state;
	private int pinCode;
	
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
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public EntireUser(String emailId, String password, String lastName, String firstName, String phoneNumber,
			String houseNumber, String streetName, String city, String state, int pinCode) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.phoneNumber = phoneNumber;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	
	public EntireUser()
	{
		
	}
	
	
	
}
