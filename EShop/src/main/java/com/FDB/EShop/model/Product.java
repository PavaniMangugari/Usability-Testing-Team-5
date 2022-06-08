package com.FDB.EShop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int productId;
	
	private int categoryId;
	private String productName;
	private String productDescription ;
	private int product_original_price;
	private int product_price;
	private int product_rating;
	private String productImage;
	private String productColor;
	
	
	public Product()
	{
		
	}
	
	public Product(int productId, int categoryId, String productName, String productDescription,
			int product_original_price, int product_price, int product_rating, String productImage,
			String productColor) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.product_original_price = product_original_price;
		this.product_price = product_price;
		this.product_rating = product_rating;
		this.productImage = productImage;
		this.productColor = productColor;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getProduct_original_price() {
		return product_original_price;
	}
	public void setProduct_original_price(int product_original_price) {
		this.product_original_price = product_original_price;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_rating() {
		return product_rating;
	}
	public void setProduct_rating(int product_rating) {
		this.product_rating = product_rating;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

}
