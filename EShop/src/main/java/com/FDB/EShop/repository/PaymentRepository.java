package com.FDB.EShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.PaymentDetails;

public interface PaymentRepository  extends JpaRepository<PaymentDetails, Integer>  {

}
