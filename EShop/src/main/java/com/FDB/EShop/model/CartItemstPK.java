package com.FDB.EShop.model;

import java.io.Serializable;

import javax.persistence.Id;

public class CartItemstPK implements Serializable{

	protected int cartId;
	protected int productId;
	
	public CartItemstPK(){
		
	}

	public CartItemstPK(int cartId, int productId) {
		super();
		this.cartId = cartId;
		this.productId = productId;
	}
	
	
	
}
