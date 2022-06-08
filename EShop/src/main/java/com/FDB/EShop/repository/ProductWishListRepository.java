package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FDB.EShop.model.Product;
import com.FDB.EShop.model.ProductWishlist;

public interface ProductWishListRepository extends JpaRepository<ProductWishlist,Integer> {

	@Query(value = "SELECT  IFNULL(max(wishlist_id), 0 )  FROM product_wishList", nativeQuery = true)
	int getWishListId();
	
	public ProductWishlist findByEmailId(String emailId);
	public int deleteAllByWishlistId(int wishListId);
	
}

