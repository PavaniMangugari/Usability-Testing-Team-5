package com.FDB.EShop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntireActiveOrders {

private int orderId;
	
	private String emailId;
	private Date orderDate;
	private String orderStatus;
	private List<Product> productsArray;
	private List<OrderDetails> orderDetails;
	
	


	public EntireActiveOrders(int orderId, String emailId, Date orderDate, String orderStatus,
			List<Product> productsArray, List<OrderDetails> orderDetails) {
		super();
		this.orderId = orderId;
		this.emailId = emailId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.productsArray = productsArray;
		this.orderDetails = orderDetails;
	}




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




	public List<Product> getProductsArray() {
		return productsArray;
	}




	public void setProductsArray(List<Product> productsArray) {
		this.productsArray = productsArray;
	}




	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}




	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}




	public EntireActiveOrders()
	{
		
	}
	
	
}
