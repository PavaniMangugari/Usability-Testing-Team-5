package com.FDB.EShop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Deals {

	@Id
	private int dealId ;
	private String dealType;
	private Date expiryDate;
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public String getDealType() {
		return dealType;
	}
	public void setDeal_Type(String dealType) {
		this.dealType = dealType;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Deals(int dealId, String dealType, Date expiryDate) {
		super();
		this.dealId = dealId;
		this.dealType = dealType;
		this.expiryDate = expiryDate;
	}
	
	public Deals()
	{
		
	}
	
}
