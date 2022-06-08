package com.FDB.EShop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CancelOrders {

	@Id
	private int orderId;
	
	private Date canceledDate;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getCanceledDate() {
		return canceledDate;
	}

	public void setCanceledDate(Date canceledDate) {
		this.canceledDate = canceledDate;
	}

	public CancelOrders(int orderId, Date canceledDate) {
		super();
		this.orderId = orderId;
		this.canceledDate = canceledDate;
	}
	
	public CancelOrders()
	{
		
	}
	
	
}
