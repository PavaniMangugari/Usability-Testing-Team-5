package com.FDB.EShop.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.Product;
import com.FDB.EShop.repository.CouponsRepository;

@Service
@Transactional
public class CouponService {

	@Autowired
	CouponsRepository repository;
	
	public List<Coupons> getAllValidCoupons()
	{
		return repository.getValidCoupons();   
	}
	
	public List<Coupons> getAllCoupons()
	{
		return repository.findAll();  
	}
	
}
