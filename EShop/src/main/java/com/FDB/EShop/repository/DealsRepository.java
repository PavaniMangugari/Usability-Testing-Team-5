package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FDB.EShop.model.CustomerHistory;
import com.FDB.EShop.model.Deals;

public interface DealsRepository  extends JpaRepository<Deals, Integer>{

}
