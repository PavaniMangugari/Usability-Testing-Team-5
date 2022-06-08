package com.FDB.EShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.FDB.EShop.model.CityDetails;
import com.FDB.EShop.model.Product;
import com.FDB.EShop.model.User;

public interface CityDetailsRepository   extends JpaRepository<CityDetails,Integer> {

	
	@Query(value = "update city_details set "
			+ "city=?1,"
			+ "state=>2,"
			+ "where pinCode=?3", nativeQuery = true)
	CityDetails updateUser(String city,String state,int pinCode);
	
	@Modifying
	@Query(value = "update city_details set "
			+ "city=?1,"
			+ "state=?2 where pin_code=?3", nativeQuery = true)
	int userAddressUpdate(String city,String state,int pinCode);
	
	@Modifying
	@Query(value = "delete from city_details where pin_code=?1", nativeQuery = true)
	int deleteExistingPincode(int pinCode);
	
	public CityDetails findByPinCode(int pinCode);
	
	
	
	@Query(value = "select * from city_details where pin_code=?1", nativeQuery = true)
	public List<CityDetails> findAllByPincode(int pinCode);
	
	
	
}
