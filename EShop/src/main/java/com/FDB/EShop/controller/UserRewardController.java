package com.FDB.EShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FDB.EShop.Service.CouponService;
import com.FDB.EShop.Service.UserRewardService;
import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.EntireRewardDetails;
import com.FDB.EShop.model.UserRewards;

@CrossOrigin(origins = "*")
@RestController
public class UserRewardController {

	@Autowired
	UserRewardService service;
	

	@PostMapping("/getAllRewards")
	 public List<EntireRewardDetails> getAllRewards(@RequestBody String emailId ) {
	        ResponseEntity responseEntity;
	      
	        List<EntireRewardDetails> rewards=service.getAllRewards(emailId);
	        	
	        return rewards;
	    }
	
	@PostMapping("/checkValidRewards")
	 public List<EntireRewardDetails> checkValidRewards(@RequestBody String emailId ) {
	        ResponseEntity responseEntity;
	      
	        List<EntireRewardDetails> rewards=service.getAllValidRewards(emailId);
	        	
	        return rewards;
	    }
	
	
	
}
