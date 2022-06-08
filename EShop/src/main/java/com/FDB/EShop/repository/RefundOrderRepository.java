package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.RefundHistory;

public interface RefundOrderRepository  extends JpaRepository<RefundHistory, Integer>{

}
