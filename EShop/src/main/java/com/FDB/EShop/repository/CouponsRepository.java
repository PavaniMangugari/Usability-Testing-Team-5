package com.FDB.EShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FDB.EShop.model.ProductCart;
import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.Product;

public interface CouponsRepository  extends JpaRepository<Coupons, Integer> {

	public Coupons findByCouponId(int couponId); 
	
	@Query(value = "SELECT * FROM Coupons where DATE(valid_end_date)>Date(CURDATE())", nativeQuery = true)
	List<Coupons> getValidCoupons();
	
	
}
