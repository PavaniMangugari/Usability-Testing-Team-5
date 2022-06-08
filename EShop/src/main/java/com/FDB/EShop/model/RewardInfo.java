package com.FDB.EShop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RewardInfo {

	@Id
	private int rewardId;
	private int amountReward;
	private Date expiryDate;
	public int getRewardId() {
		return rewardId;
	}
	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}
	public int getAmountReward() {
		return amountReward;
	}
	public void setAmountReward(int amountReward) {
		this.amountReward = amountReward;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public RewardInfo(int rewardId, int amountReward, Date expiryDate) {
		super();
		this.rewardId = rewardId;
		this.amountReward = amountReward;
		this.expiryDate = expiryDate;
	}
	
	public RewardInfo()
	{
		
	}
	
	
}
