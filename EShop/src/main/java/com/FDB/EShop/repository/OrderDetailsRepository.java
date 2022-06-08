package com.FDB.EShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.OrderDetails;

public interface OrderDetailsRepository   extends JpaRepository<OrderDetails, Integer> {

	@Query(value = "SELECT * FROM order_details where order_id=?1", nativeQuery = true)
	 List<OrderDetails> findByOrderId(int orderId);
	
	
	
}
