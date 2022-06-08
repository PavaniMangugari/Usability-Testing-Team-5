package com.FDB.EShop.model;

import javax.persistence.Id;

public class EntireWishListDetails {
	private int wishlistId;
	 private int productId;
		private String emailId;
	private String productType;
	private String  productImage;
	private String ProductName;
	private int price;
	
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public EntireWishListDetails(int wishlistId, int productId,int price, String emailId, String productType, String productImage,
			String productName) {
		super();
		this.wishlistId = wishlistId;
		this.productId = productId;
		this.emailId = emailId;
		this.productType = productType;
		this.productImage = productImage;
		this.ProductName=productName;
		this.price=price;
	}
	public EntireWishListDetails()
	{
		
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
