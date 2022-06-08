package com.FDB.EShop.model;

import java.io.Serializable;

import javax.persistence.Id;

public class RefundHistoryPK implements Serializable{

	
	
	private int orderId;
	private int productId;
	private int refundAmount;
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
	public int getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}
	public RefundHistoryPK(int orderId, int productId, int refundAmount) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.refundAmount = refundAmount;
	}
	
	public RefundHistoryPK()
	{
		
	}
	
}
