package com.FDB.EShop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupons {

	@Id
	private int couponId;
	
	private Date validStartDate;
	private Date validEndDate;
	private int couponAmount;
	
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public Date getValidStartDate() {
		return validStartDate;
	}
	public void setValidStartDate(Date validStartDate) {
		this.validStartDate = validStartDate;
	}
	public Date getValidEndDate() {
		return validEndDate;
	}
	public void setValid_endDate(Date validEndDate) {
		this.validEndDate = validEndDate;
	}
	public int getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(int couponAmount) {
		this.couponAmount = couponAmount;
	}
	public Coupons(int couponId, Date validStartDate, Date validEndDate, int couponAmount) {
		super();
		this.couponId = couponId;
		this.validStartDate = validStartDate;
		this.validEndDate = validEndDate;
		this.couponAmount = couponAmount;
	}
	
	public Coupons()
	{
		
	}
	
}
