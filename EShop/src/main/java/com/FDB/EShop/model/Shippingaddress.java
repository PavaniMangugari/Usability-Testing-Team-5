package com.FDB.EShop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shippingaddress {

	@Id
	private String emailId;
	
	private String houseNumber;
	private String streetName;
	private int pinCode;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public Shippingaddress(String emailId, String houseNumber, String streetName, int pincode) {
		super();
		this.emailId = emailId;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.pinCode = pinCode;
	}
	
	public Shippingaddress()
	{
		
	}
	
	
}
