package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FDB.EShop.model.ReturnOrders;
import com.FDB.EShop.model.UserRewards;

public interface ReturnOrderRepository   extends JpaRepository<ReturnOrders, Integer>{

}
