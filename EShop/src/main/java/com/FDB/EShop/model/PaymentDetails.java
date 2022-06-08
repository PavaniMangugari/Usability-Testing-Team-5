package com.FDB.EShop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentDetails {

	@Id
	private int payment_id;
	
	private int order_id;
	private String payment_type;
	private String payment_value;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getPayment_value() {
		return payment_value;
	}
	public void setPayment_value(String payment_value) {
		this.payment_value = payment_value;
	}
	public PaymentDetails(int payment_id, int order_id, String payment_type, String payment_value) {
		super();
		this.payment_id = payment_id;
		this.order_id = order_id;
		this.payment_type = payment_type;
		this.payment_value = payment_value;
	}
	
	public PaymentDetails()
	{
		
	}
}
