package com.FDB.EShop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FDB.EShop.Service.CouponService;
import com.FDB.EShop.model.CartItems;
import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.Product;
import com.FDB.EShop.model.ProductCart;

@CrossOrigin(origins = "*")
@RestController
public class CouponController {

	@Autowired
	CouponService service;
	
	@PostMapping("/checkCouponValidity")
	 public List<Coupons> checkCouponValidity(@RequestBody String emailId ) {
	        ResponseEntity responseEntity;
	      
	        	List<Coupons> coupons=service.getAllValidCoupons();
	        	
	        return coupons;
	    }
	
	@PostMapping("/getAllCoupons")
	 public List<Coupons> getAllCoupons(@RequestBody String emailId) {
	        ResponseEntity responseEntity;
	      
	        	List<Coupons> coupons=service.getAllCoupons();
	        	
	        return coupons;
	    }
	
	
}
