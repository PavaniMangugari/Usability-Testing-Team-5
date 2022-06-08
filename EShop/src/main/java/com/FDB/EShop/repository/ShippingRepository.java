package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FDB.EShop.model.Shippingaddress;
import com.FDB.EShop.model.User;

public interface ShippingRepository  extends JpaRepository<Shippingaddress,Integer> {

	
	@Query(value = "update user set house_number=?2,"
			+ "street_name =?3,"
			+ "pincode=?4 where email_id=?1", nativeQuery = true)
	Shippingaddress updateUser(String email_id,String house_number,String street_name,int pincode );
	
	
	Shippingaddress findByEmailId(String emailId);
}
