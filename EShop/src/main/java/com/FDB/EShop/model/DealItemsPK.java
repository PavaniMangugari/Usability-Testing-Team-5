package com.FDB.EShop.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class DealItemsPK  implements Serializable{

	private int dealId;
	private int productId;
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public DealItemsPK(int dealId, int productId) {
		super();
		this.dealId = dealId;
		this.productId = productId;
	}
	
	public DealItemsPK()
	{
		
	}
	
}
