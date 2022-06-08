package com.FDB.EShop.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FDB.EShop.model.EntireActiveOrders;
import com.FDB.EShop.model.EntireReturnOrder;
import com.FDB.EShop.model.OrderDetails;
import com.FDB.EShop.model.OrderUser;
import com.FDB.EShop.model.Product;
import com.FDB.EShop.model.ReturnOrders;
import com.FDB.EShop.repository.OrderDetailsRepository;
import com.FDB.EShop.repository.OrderRepository;
import com.FDB.EShop.repository.ReturnOrderRepository;

@Service
@Transactional
public class ReturnOrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ReturnOrderRepository returnOrderRepo;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepo;
	
	@Autowired
	ProductsService productService;
	
	public ReturnOrders returnOrder(String emailId,String reason,int OrderId)
	{
		orderRepo.updateOrderIdForReturn(emailId, OrderId);
		return insertReturnOrderDetails(emailId, reason, OrderId);
	}
	
	public ReturnOrders insertReturnOrderDetails(String emailId,String reason,int OrderId)
	{
		ReturnOrders returnOrder=new ReturnOrders();
		returnOrder.setOrder_id(OrderId);
		returnOrder.setPickedup_not(true);
		returnOrder.setReason(reason);
		orderRepo.updateOrderIdForReturn(emailId, OrderId);
		return returnOrderRepo.save(returnOrder);
	}
	
	public ReturnOrders insertCancelledOrders(String emailId,int OrderId)
	{
		ReturnOrders returnOrder=new ReturnOrders();
		returnOrder.setOrder_id(OrderId);
		returnOrder.setPickedup_not(true);
		orderRepo.updateOrderIdForReturn(emailId, OrderId);
		return returnOrderRepo.save(returnOrder);
	}
	
	
	
	
	
	public List<EntireReturnOrder> fetchAllReturnOrdersForUser(String emailId)
	{
		List<OrderUser> orderUser=orderRepo.fetchReceivedOrder(emailId);
		List<EntireReturnOrder> activeOrdersForUser=new ArrayList<EntireReturnOrder>();
		for(OrderUser activeOrder:orderUser)
		{
			EntireReturnOrder userActiveOrder=new EntireReturnOrder();
			userActiveOrder.setEmailId(activeOrder.getEmailId());
			userActiveOrder.setOrderDate(activeOrder.getOrderDate());
			userActiveOrder.setOrderId(activeOrder.getOrderId());
			userActiveOrder.setOrderStatus(activeOrder.getOrderStatus());
			List<OrderDetails> orderDetails=new ArrayList<OrderDetails>();
			orderDetails=orderDetailsRepo.findByOrderId(activeOrder.getOrderId());
			userActiveOrder.setOrderDetails(orderDetails);
			List<Product> orderProducts=new ArrayList<Product>();
			for(OrderDetails orders:orderDetails)
			{
			
				Product product=productService.getProductsDetails(orders.getProductId());
				orderProducts.add(product);
				
			}
			userActiveOrder.setProductsArray(orderProducts);
			activeOrdersForUser.add(userActiveOrder);
			
		}
		return activeOrdersForUser;
		
	}
	
}
