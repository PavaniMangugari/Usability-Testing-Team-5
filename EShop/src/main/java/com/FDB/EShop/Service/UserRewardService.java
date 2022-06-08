package com.FDB.EShop.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.EntireRewardDetails;
import com.FDB.EShop.model.RewardInfo;
import com.FDB.EShop.model.UserRewards;
import com.FDB.EShop.repository.RewardInfoRepository;
import com.FDB.EShop.repository.UserRewardRepository;

@Service
@Transactional
public class UserRewardService {

	@Autowired
	UserRewardRepository rewardsRepository;
	
	@Autowired
	RewardInfoRepository rewardInfoRepo;
	
	public List<EntireRewardDetails> getAllValidRewards(String emailId)
	{
		
		List<UserRewards> userRewards=rewardsRepository.findByEmailId(emailId);
		List<EntireRewardDetails> entireUserReward=new ArrayList<EntireRewardDetails>();
		for(UserRewards rewards:userRewards)
		{
			EntireRewardDetails rewardDetails=new EntireRewardDetails();
			rewardDetails.setEmailId(emailId);
			rewardDetails.setRewardId(rewards.getRewardId());
			RewardInfo info=rewardInfoRepo.findActiveRewards(rewards.getRewardId());
			rewardDetails.setAmountReward(info.getAmountReward());
			rewardDetails.setExpiryDate(info.getExpiryDate());
			entireUserReward.add(rewardDetails);
		}
		return entireUserReward;
	
	}
	
	public List<EntireRewardDetails> getAllRewards(String emailId)
	{
		List<UserRewards> userRewards=rewardsRepository.findByEmailId(emailId);
		List<EntireRewardDetails> entireUserReward=new ArrayList<EntireRewardDetails>();
		for(UserRewards rewards:userRewards)
		{
			EntireRewardDetails rewardDetails=new EntireRewardDetails();
			rewardDetails.setEmailId(emailId);
			rewardDetails.setRewardId(rewards.getRewardId());
			RewardInfo info=rewardInfoRepo.findAllRewardsForUser(rewards.getRewardId());
			rewardDetails.setAmountReward(info.getAmountReward());
			rewardDetails.setExpiryDate(info.getExpiryDate());
			entireUserReward.add(rewardDetails);
		}
		return entireUserReward; 
	}
	
	
}
