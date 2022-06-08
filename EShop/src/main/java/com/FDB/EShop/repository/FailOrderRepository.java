package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FDB.EShop.model.CancelOrders;
import com.FDB.EShop.model.Coupons;

public interface FailOrderRepository  extends JpaRepository<CancelOrders, Integer>{

}
