package com.FDB.EShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.FDB.EShop.model.CartItems;
import com.FDB.EShop.model.ProductCart;
import com.FDB.EShop.model.WishlistItems;

public interface ProuctCartItemsRepository extends JpaRepository<CartItems, Integer> {

	
	public List<CartItems> findByCartId(Integer cartId);
	public int deleteByCartId(int cartId);
	
	@Query(value = "select count(product_id) from cart_items where cart_id=?1", nativeQuery = true)
	int getCartItemsCount(int cartId);
	
	@Modifying
	@Query(value = "delete from cart_items where cart_id=?1 and product_id=?2", nativeQuery = true)
	public int deleteByCartIdAndProductId(int cartId,int productId);
	
}
