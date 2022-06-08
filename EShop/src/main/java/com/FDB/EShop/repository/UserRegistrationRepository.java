package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FDB.EShop.model.User;

public interface UserRegistrationRepository  extends JpaRepository<User,Integer>  {
	
public User findByEmailId(String emailId); 
	
	public User findByEmailIdAndPassword(String emailId, String password); 

}
