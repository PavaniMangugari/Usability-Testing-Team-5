package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FDB.EShop.model.Category;
import com.FDB.EShop.model.CityDetails;

public interface CategoryRepository   extends JpaRepository<Category,Integer> {

}
