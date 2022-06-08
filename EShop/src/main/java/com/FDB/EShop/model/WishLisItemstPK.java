package com.FDB.EShop.model;

import java.io.Serializable;

import javax.persistence.Id;

public class WishLisItemstPK implements Serializable {

	
	private int wishlistId;
	 private int productId;
	 private String productType;
	 
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public WishLisItemstPK(int wishlistId, int productId,String productType) {
		super();
		this.wishlistId = wishlistId;
		this.productId = productId;
		this.productType=productType;
	}
	public WishLisItemstPK()
	{
		
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
}
