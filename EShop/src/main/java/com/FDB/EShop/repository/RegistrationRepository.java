package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FDB.EShop.model.User;
public interface RegistrationRepository extends JpaRepository<User,Integer> {

	public User findByEmailId(String emailId);  
	
	public User findByEmailIdAndPassword(String emailId, String password); 

	@Query(value = "update user set house_number=?2,"
			+ "street_name =?3,"
			+ "city=?4,"
			+ "state=>5,"
			+ "pincode=?6 where email_id=?1", nativeQuery = true)
	User updateUser(String email_id,String house_number,String street_name,String city,String state,int pincode );
	
}
