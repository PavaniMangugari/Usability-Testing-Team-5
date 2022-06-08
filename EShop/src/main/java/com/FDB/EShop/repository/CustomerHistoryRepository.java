package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.CustomerHistory;

public interface CustomerHistoryRepository  extends JpaRepository<CustomerHistory, Integer>{

}
