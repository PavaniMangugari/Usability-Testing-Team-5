package com.FDB.EShop.model;

import java.io.Serializable;

public class CartPrimaryKey implements Serializable{

	protected String emailId;
	protected int cartId;
	
	public CartPrimaryKey(){
		
	}

	public CartPrimaryKey(String emailId, int cartId) {
		super();
		this.emailId = emailId;
		this.cartId = cartId;
	}
	
	
	
}




