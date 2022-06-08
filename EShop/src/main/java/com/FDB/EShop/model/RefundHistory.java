package com.FDB.EShop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(RefundHistoryPK.class)
public class RefundHistory {

	@Id
	private int orderId;
	
	@Id
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

	public RefundHistory(int orderId, int productId, int refundAmount) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.refundAmount = refundAmount;
	}
	public RefundHistory()
	{
		
	}
	
	
	
	
}
