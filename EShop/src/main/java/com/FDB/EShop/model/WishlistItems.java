package com.FDB.EShop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(WishLisItemstPK.class)
public class WishlistItems {

	@Id
	private int wishlistId;
	@Id
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
	public String getProduct_type() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public WishlistItems()
	{
		
	}
	public WishlistItems(int wishlistId, int product_id, String product_type) {
		super();
		this.wishlistId = wishlistId;
		this.productId = productId;
		this.productType = productType;
	}
	
	
}
