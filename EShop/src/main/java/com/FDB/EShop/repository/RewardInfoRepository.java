package com.FDB.EShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FDB.EShop.model.RewardInfo;
import com.FDB.EShop.model.UserRewards;

public interface RewardInfoRepository   extends JpaRepository<RewardInfo, Integer>{

	
	@Query(value = "SELECT * FROM reward_info where DATE(expiry_date)>Date(CURDATE()) and reward_id=?1", nativeQuery = true)
	RewardInfo findActiveRewards(int rewardId);
	
	@Query(value = "SELECT * FROM reward_info where reward_id=?1", nativeQuery = true)
	RewardInfo findAllRewardsForUser(int rewardId);
	
	
	
}
