package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.ProductCart;
import com.FDB.EShop.model.UserRewards;

public interface UserRewardRepository   extends JpaRepository<UserRewards, Integer>{

	
	
	
	@Query(value = "SELECT * FROM user_rewards where email_id=?1", nativeQuery = true)
	List<UserRewards> findByEmailId(String emailId);
	
	
	
}
