package com.FDB.EShop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FDB.EShop.Service.OrderService;
import com.FDB.EShop.model.EntireActiveOrders;
import com.FDB.EShop.model.OrderUser;
import com.FDB.EShop.model.Product;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/orderUserDetails")
	public OrderUser saveOrderUserDetails(@RequestBody ArrayList<Object> details) throws Exception
	{
		return orderService.saveAllOrders(details.get(0).toString(),details.get(1).toString());
	}
	
	
	@PostMapping("/cancelOrders")
	public int cancelOrders(@RequestBody ArrayList<Object> details) throws Exception
	{
		return orderService.failOrders(Integer.parseInt(details.get(0).toString()),details.get(1).toString());
	}
	
	@PostMapping("/receivedOrders")
	public List<EntireActiveOrders> receivedOrders(@RequestBody String emailId) throws Exception
	{
		return orderService.receivedOrderDetails(emailId);
	}
	
	
	@PostMapping("/fetchAllOrders")
	public List<EntireActiveOrders> fetchAllOrders(@RequestBody String emailId) throws Exception
	{
		return orderService.fetchAllOrders(emailId);
	}
	
	
	@PostMapping("/fetchAllActiveOrders")
	public List<EntireActiveOrders> fetchAllActiveOrders(@RequestBody String emailId) throws Exception
	{
		return orderService.fetchAllActiveOrdersForUser(emailId);
	}
	
}
