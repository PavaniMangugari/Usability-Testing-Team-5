package com.FDB.EShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.FDB.EShop.model.ProductWishlist;
import com.FDB.EShop.model.WishlistItems;

public interface ProductWishListItemsRepository extends JpaRepository<WishlistItems,Integer> {

	public List<WishlistItems> findByWishlistId(Integer wishList);

	public int deleteAllByWishlistId(Integer wishList);
	
	@Modifying
	@Query(value = "delete from wishlist_items where wishlist_id=?1 and product_id=?2", nativeQuery = true)
	public int deleteAllByWishlistIdAndProductId(Integer wishList,Integer productId);
}
