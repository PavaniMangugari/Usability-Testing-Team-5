package com.FDB.EShop.model;

import java.io.Serializable;

public class WishListPK implements Serializable{
	protected String emailId;
	protected int wishlistId;
	
	public WishListPK(){
		
	}

	public WishListPK(String emailId, int wishlistId) {
		super();
		this.emailId = emailId;
		this.wishlistId = wishlistId;
	}

	
	
}
