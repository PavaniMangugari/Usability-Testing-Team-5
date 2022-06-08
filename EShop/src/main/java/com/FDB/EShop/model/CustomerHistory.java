package com.FDB.EShop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CustomerHistoryPK.class)
public class CustomerHistory {

	
	@Id
	private String emailId;
	
	@Id
	private int orderId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public CustomerHistory(String emailId, int orderId) {
		super();
		this.emailId = emailId;
		this.orderId = orderId;
	}
	
	
	public CustomerHistory()
	{
		
	}

	
	
}
