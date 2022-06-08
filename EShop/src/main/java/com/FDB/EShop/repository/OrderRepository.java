package com.FDB.EShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.FDB.EShop.model.Coupons;
import com.FDB.EShop.model.OrderUser;

public interface OrderRepository   extends JpaRepository<OrderUser, Integer>  {


	@Query(value = "SELECT IFNULL(max(order_id), 0 )  FROM order_user", nativeQuery = true)
	Integer getOrderIdMax();
	
	@Query(value="select * from order_user where email_id=?1 and order_status='ACTIVE' ", nativeQuery = true)
	public List<OrderUser> findByEmailId(String emailId);
	
	@Query(value="select * from order_user where email_id=?1 and order_status='RETURN' ", nativeQuery = true)
	public List<OrderUser> fetchReceivedOrder(String emailId);
	
	
	@Query(value="select * from order_user where email_id=?1 ", nativeQuery = true)
	public List<OrderUser> fetchAllOrders(String emailId);
	
	@Query(value="select * from order_user where email_id=?1 and order_status='FAILED' ", nativeQuery = true)
	public List<OrderUser> fetchFailedOrders(String emailId);
	
	@Query(value="select * from order_user where email_id=?1 and order_status='DELIVERED' ", nativeQuery = true)
	public List<OrderUser> fetchReceivedOrders(String emailId);
	
	@Modifying
	@Query(value="update order_user set order_status='RETURN' where email_id=?1 and order_id=?2", nativeQuery = true)
	public int updateOrderIdForReturn(String emailId,int order_id);
	
	@Modifying
	@Query(value="update order_user set order_status='Failed' where email_id=?1 and order_id=?2", nativeQuery = true)
	public int updateOrderIdForCancel(String emailId,int order_id);
	
	@Modifying
	@Query(value="update order_user set order_status='DELIVERED' where email_id=?1 AND order_date>ADDDATE(CURDATE(), 7)", nativeQuery = true)
	public int updateOrderStatusToDelivered(String emailId);
}
