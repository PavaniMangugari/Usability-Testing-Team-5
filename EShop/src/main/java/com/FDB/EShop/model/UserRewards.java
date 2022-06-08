package com.FDB.EShop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRewards {

	@Id
	private int rewardId;
	private String emailId;
	
	
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

	public UserRewards(int rewardId, String emailId) {
		super();
		this.rewardId = rewardId;
		this.emailId = emailId;
	}
	public UserRewards()
	{
		
	}
	
	
	
}
