package com.FDB.EShop.model;

import java.io.Serializable;

import javax.persistence.Id;

public class CustomerHistoryPK  implements Serializable {

private String emailId;
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
	public CustomerHistoryPK(String emailId, int orderId) {
		super();
		this.emailId = emailId;
		this.orderId = orderId;
	}
	
	public CustomerHistoryPK()
	{
		
	}
	
}
