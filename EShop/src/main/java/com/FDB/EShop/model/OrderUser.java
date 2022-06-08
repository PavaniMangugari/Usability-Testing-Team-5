package com.FDB.EShop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class OrderUser {
	@Id
	private int orderId;
	
	private String emailId;
	private Date orderDate;
	private String orderStatus;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public OrderUser(int orderId, String emailId, Date orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.emailId = emailId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	public OrderUser()
	{
		
	}
	
}
