package com.FDB.EShop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReturnOrders {

	@Id
	private int order_id;
	private boolean pickedup_not;
	private String reason;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public boolean isPickedup_not() {
		return pickedup_not;
	}
	public void setPickedup_not(boolean pickedup_not) {
		this.pickedup_not = pickedup_not;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public ReturnOrders(int order_id, boolean pickedup_not, String reason) {
		super();
		this.order_id = order_id;
		this.pickedup_not = pickedup_not;
		this.reason = reason;
	}
	public ReturnOrders()
	{
		
	}
	
	
}
