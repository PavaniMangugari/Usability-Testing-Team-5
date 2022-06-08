package com.FDB.EShop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CartItemstPK.class)
public class CartItems {
	@Id 
	private int cartId;
	@Id
	private int productId;
	
	private int count;
	private int price;
	
	
	public CartItems()
	{
		
	}
	
	
	public CartItems(int cartId, int productId, int count, int price) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		
		this.count = count;
		this.price = price;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
