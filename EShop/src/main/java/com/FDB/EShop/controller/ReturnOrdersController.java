package com.FDB.EShop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FDB.EShop.Service.ReturnOrderService;
import com.FDB.EShop.model.EntireActiveOrders;
import com.FDB.EShop.model.EntireReturnOrder;
import com.FDB.EShop.model.ReturnOrders;
import com.FDB.EShop.model.WishlistItems;

@CrossOrigin(origins = "*")
@RestController
public class ReturnOrdersController {

	@Autowired
	ReturnOrderService returnOrderService;
	
	
	@PostMapping("/returnOrder")
	 public ReturnOrders returnOrder(@RequestBody ArrayList<Object> returnOrder) throws NumberFormatException {
		
		int orderId=Integer.parseInt(returnOrder.get(0).toString());
		String emailId=returnOrder.get(2).toString();
		String reason=returnOrder.get(1).toString();
		return returnOrderService.insertReturnOrderDetails(emailId, reason, orderId);
	    }
	
	@PostMapping("/cancelOrder")
	 public ReturnOrders cancelOrder(@RequestBody ArrayList<Object> returnOrder) throws NumberFormatException {
		
		int orderId=Integer.parseInt(returnOrder.get(0).toString());
		String emailId=returnOrder.get(1).toString();
		return returnOrderService.insertCancelledOrders(emailId,orderId);
	    }
	

	@PostMapping("/fetchAllReturnOrder")
	public List<EntireReturnOrder> fetchAllReturnOrder(@RequestBody String emailId) throws Exception
	{
		System.out.println("check");
		return returnOrderService.fetchAllReturnOrdersForUser(emailId);
	}
	
}
