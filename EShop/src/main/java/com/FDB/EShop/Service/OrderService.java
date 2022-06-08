package com.FDB.EShop.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FDB.EShop.model.CancelOrders;
import com.FDB.EShop.model.CartItems;
import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.CustomerHistory;
import com.FDB.EShop.model.EntireActiveOrders;
import com.FDB.EShop.model.EntireShoppingCart;
import com.FDB.EShop.model.OrderDetails;
import com.FDB.EShop.model.OrderUser;
import com.FDB.EShop.model.PaymentDetails;
import com.FDB.EShop.model.Product;
import com.FDB.EShop.model.RefundHistory;
import com.FDB.EShop.repository.CouponsRepository;

import com.FDB.EShop.repository.CustomerHistoryRepository;
import com.FDB.EShop.repository.FailOrderRepository;
import com.FDB.EShop.repository.OrderDetailsRepository;
import com.FDB.EShop.repository.OrderRepository;
import com.FDB.EShop.repository.PaymentRepository;
import com.FDB.EShop.repository.RefundOrderRepository;
import com.FDB.EShop.repository.ReturnOrderRepository;

@Service
@Transactional
public class OrderService {

	
	
	@Autowired
	OrderRepository repository;
	
	@Autowired
	ProductCartService cartService;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepo;
	
	@Autowired
	ProductsService productsService;
	
	@Autowired
	FailOrderRepository failedOrderRepo;
	
	@Autowired
	CustomerHistoryRepository customerHistoryRepo;
	
	@Autowired
	RefundOrderRepository refundRepo;
	
	@Autowired
	PaymentRepository paymentRepo;
	
	public OrderUser saveAllOrders(String emailId,String price)
	{
		OrderUser orderUser=new OrderUser();
		orderUser.setEmailId(emailId);
		Date currentDate=new Date();
		orderUser.setOrderDate(currentDate);
		orderUser.setOrderStatus("ACTIVE");
		repository.save(orderUser);
		saveOrderDetails(emailId,price);
		
		return orderUser;
		
	}
	public int saveOrderDetails(String emailId,String price)
	{
		int maxOrderId=orderRepo.getOrderIdMax();
		List<EntireShoppingCart>totalCart=cartService.retrieveCartDetailsForUser(emailId);
		for(EntireShoppingCart cart:totalCart)
		{
			Date today = new Date();
			long ltime = today.getTime()+10*24*60*60*1000;
			Date newDate = new Date(ltime);
			
			OrderDetails orderDetails=new OrderDetails();
			orderDetails.setOrderId(maxOrderId);
			orderDetails.setEstimatedDeliveryDate(newDate);
			orderDetails.setProductId(cart.getProductId());
			cartService.deleteFromCartRepo(emailId,orderDetails.getProductId());
			orderDetailsRepo.save(orderDetails);
			
			CustomerHistory customerHistory=new CustomerHistory();
			customerHistory.setEmailId(emailId);
			customerHistory.setOrderId(orderDetails.getOrderId());
			customerHistoryRepo.save(customerHistory);
			
			
		}
		saveToCustomerHistory(emailId,maxOrderId);
		
		paymentDetails(emailId,price,maxOrderId);
		return 1;
		
	}
	public int paymentDetails(String emailId,String price,int maxOrderId)
	{
		PaymentDetails paymentDetails=new PaymentDetails();
		paymentDetails.setOrder_id(maxOrderId);
		paymentDetails.setPayment_type("Card");
		paymentDetails.setPayment_value((price));
		paymentRepo.save(paymentDetails);
		
		
		return 1;
	}
	public int saveToCustomerHistory(String emailId,int maxOrderId)
	{
		CustomerHistory history=new CustomerHistory();
		history.setEmailId(emailId);
		history.setOrderId(maxOrderId);
		customerHistoryRepo.save(history);
		
		
		return 1;
	}
	
	public List<EntireActiveOrders> fetchAllActiveOrdersForUser(String emailId)
	{
		changeActiveToDeliveredOrders(emailId);
		List<OrderUser> orderUser=orderRepo.findByEmailId(emailId);
		List<EntireActiveOrders> activeOrdersForUser=new ArrayList<EntireActiveOrders>();
		for(OrderUser activeOrder:orderUser)
		{
			EntireActiveOrders userActiveOrder=new EntireActiveOrders();
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
			
				Product product=productsService.getProductsDetails(orders.getProductId());
				orderProducts.add(product);
				
			}
			userActiveOrder.setProductsArray(orderProducts);
			activeOrdersForUser.add(userActiveOrder);
			
		}
		return activeOrdersForUser;
		
	}
	
	
	
	public List<EntireActiveOrders> fetchAllOrders(String emailId)
	{
		changeActiveToDeliveredOrders(emailId);
		List<OrderUser> orderUser=orderRepo.fetchAllOrders(emailId);
		List<EntireActiveOrders> activeOrdersForUser=new ArrayList<EntireActiveOrders>();
		for(OrderUser activeOrder:orderUser)
		{
			EntireActiveOrders userActiveOrder=new EntireActiveOrders();
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
			
				Product product=productsService.getProductsDetails(orders.getProductId());
				orderProducts.add(product);
				
			}
			userActiveOrder.setProductsArray(orderProducts);
			activeOrdersForUser.add(userActiveOrder);
			
		}
		return activeOrdersForUser;
		
	}
	
	
	
	public List<EntireActiveOrders> receivedOrderDetails(String emailId)
	{
		changeActiveToDeliveredOrders(emailId);
		List<OrderUser> orderUser=orderRepo.fetchReceivedOrders(emailId);
		List<EntireActiveOrders> activeOrdersForUser=new ArrayList<EntireActiveOrders>();
		for(OrderUser activeOrder:orderUser)
		{
			EntireActiveOrders userActiveOrder=new EntireActiveOrders();
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
			
				Product product=productsService.getProductsDetails(orders.getProductId());
				orderProducts.add(product);
				
			}
			userActiveOrder.setProductsArray(orderProducts);
			activeOrdersForUser.add(userActiveOrder);
			
		}
		return activeOrdersForUser;
	}
	
	public int failOrders(int orderId,String emailId)
	{
		CancelOrders cancelOrder=new CancelOrders();
		 Date date=new Date();
		cancelOrder.setCanceledDate(date);
		cancelOrder.setOrderId(orderId);
		failedOrderRepo.save(cancelOrder);
		
		RefundHistory refund=new RefundHistory();
		refund.setOrderId(orderId);
		
		List<OrderDetails> orderDetails=new ArrayList<OrderDetails>();
		orderDetails=orderDetailsRepo.findByOrderId(orderId);
		for(OrderDetails orders:orderDetails)
		{
		
			Product product=productsService.getProductsDetails(orders.getProductId());
			refund.setProductId(orders.getProductId());
			refund.setRefundAmount(product.getProduct_price());
			refundRepo.save(refund);
			
		}
		
	CustomerHistory customerHistory=new CustomerHistory();
	customerHistory.setEmailId(emailId);
	customerHistory.setOrderId(orderId);
	customerHistoryRepo.save(customerHistory);
		
		OrderUser orderUser=new OrderUser();
	return	orderRepo.updateOrderIdForCancel(emailId, orderId);
		
	}
	
	
	public List<EntireActiveOrders> fetchCancelOrder(String emailId)
	{
		changeActiveToDeliveredOrders(emailId);
		List<OrderUser> orderUser=orderRepo.fetchFailedOrders(emailId);
		List<EntireActiveOrders> cancelOrders=new ArrayList<EntireActiveOrders>();
		for(OrderUser activeOrder:orderUser)
		{
			EntireActiveOrders userActiveOrder=new EntireActiveOrders();
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
			
				Product product=productsService.getProductsDetails(orders.getProductId());
				orderProducts.add(product);
				
			}
			userActiveOrder.setProductsArray(orderProducts);
			cancelOrders.add(userActiveOrder);
			
		}
		return cancelOrders;
	}
	
	
	
	
	public void changeActiveToDeliveredOrders(String emailId)
	{
		int orderCount=orderRepo.updateOrderStatusToDelivered(emailId);
		
		
	}
	
}
