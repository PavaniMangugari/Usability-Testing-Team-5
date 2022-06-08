package com.FDB.EShop.model;

import java.io.Serializable;

import javax.persistence.Id;

public class OrderDetailsPK implements Serializable{

private int orderId;
private int productId;



public OrderDetailsPK(int orderId, int productId) {
	super();
	this.orderId = orderId;
	this.productId = productId;
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


public OrderDetailsPK()
{
	
}
	
}
