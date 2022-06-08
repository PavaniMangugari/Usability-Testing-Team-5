package com.FDB.EShop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(OrderDetailsPK.class)
public class OrderDetails {

	@Id
	private int orderId;
	@Id
	private int productId;
	private Date estimatedDeliveryDate;
	
	
	
	public OrderDetails(int orderId, int productId, Date estimatedDeliveryDate) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}



	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public Date getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}



	public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}



	public OrderDetails()
	{
		
	}
	
	
}
