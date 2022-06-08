package com.FDB.EShop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CityDetails {

	
	@Id
	private int pinCode;
	
	private String city;
	private String state;
	
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
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
	public CityDetails(int pinCode, String city, String state) {
		super();
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
	}
	
	public CityDetails()
	{
		
	}
}
