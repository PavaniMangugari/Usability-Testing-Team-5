package com.FDB.EShop.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(WishListPK.class)

public class ProductWishlist {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wishlistId ;
	
	@Id
	private String emailId;


	public int getWishlistId() {
		return wishlistId;
	}


	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public ProductWishlist(int wishlistId, String emailId) {
		super();
		this.wishlistId = wishlistId;
		this.emailId = emailId;
	}
	
	
	public ProductWishlist()
	{
		
	}
}
