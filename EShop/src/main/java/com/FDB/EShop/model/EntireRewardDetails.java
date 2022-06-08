package com.FDB.EShop.model;

import java.util.Date;

public class EntireRewardDetails {

	
	private int rewardId;
	private String emailId;
	private int amountReward;
	private Date expiryDate;
	public int getRewardId() {
		return rewardId;
	}
	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public EntireRewardDetails(int rewardId, String emailId, int amountReward, Date expiryDate) {
		super();
		this.rewardId = rewardId;
		this.emailId = emailId;
		this.amountReward = amountReward;
		this.expiryDate = expiryDate;
	}
	
	public EntireRewardDetails()
	{
		
	}
	
}
