package com.FDB.EShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FDB.EShop.model.ProductCart;



public interface ProductCartRepository extends JpaRepository<ProductCart, Integer> {



	public ProductCart findByEmailId(String emailId);

	public int deleteByEmailId(String id);
	
	
	
	@Query(value = "SELECT max(cart_id) FROM product_cart", nativeQuery = true)
	Integer getCartId();
	
	
}




