package com.FDB.EShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FDB.EShop.model.CustomerHistory;
import com.FDB.EShop.model.DealItems;

public interface DealItemsRepository  extends JpaRepository<DealItems, Integer>{

	List<DealItems> findByDealId(int dealId);
}
