package com.FDB.EShop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(DealItemsPK.class)
public class DealItems {
	
	@Id
	private int dealId;
	@Id
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
	public DealItems(int dealId, int productId) {
		super();
		this.dealId = dealId;
		this.productId = productId;
	}
	public DealItems()
	{
		
	}

}
