package com.FDB.EShop.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CartPrimaryKey.class)
public class ProductCart implements Serializable{

	
	
	@Id
	private String emailId;
	
    @Id
	private int cartId;
	
	
	
	
	public ProductCart(String emailId, int cartId) {
		super();
		this.emailId = emailId;
		this.cartId = cartId;
	
	}
	
	public ProductCart()
	{
		
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
	



}
