package com.FDB.EShop.Service;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FDB.EShop.model.EntireWishListDetails;
import com.FDB.EShop.model.Product;
import com.FDB.EShop.model.ProductCart;
import com.FDB.EShop.model.ProductWishlist;
import com.FDB.EShop.model.WishlistItems;
import com.FDB.EShop.repository.ProductWishListItemsRepository;
import com.FDB.EShop.repository.ProductWishListRepository;

@Service
@Transactional
public class WishListService {
	
	@Autowired
	ProductWishListRepository productWishListRepository;
	
	@Autowired
	ProductWishListItemsRepository wishListItemsRepo;
	
	@Autowired
	ProductsService productsService;;
	
	
	//To save items to the user cart
		public ProductWishlist saveToWishList(ProductWishlist wishList)
		{
		return productWishListRepository.save(wishList);
			
		}
	
	public int getWishListId()
	{
	int wishListId=0;
		List<ProductWishlist>wishLists=	productWishListRepository.findAll();
		if(wishLists!=null)
		{
			wishListId= productWishListRepository.getWishListId();
		}
		return wishListId;
	}
	
	public WishlistItems saveToWishListItems(WishlistItems wishlistItems)
	{
		return wishListItemsRepo.save(wishlistItems);
	}
	

	public List<EntireWishListDetails> retrieveWishListForUser(String id)
	{
	List<ProductWishlist> AllCartDetails=productWishListRepository.findAll();
	List<Integer> wishListId=new ArrayList<Integer>();
	List<EntireWishListDetails> totalWishList=new ArrayList<EntireWishListDetails>();
	 for(ProductWishlist item:AllCartDetails)
	 {
		 if(item.getEmailId().equalsIgnoreCase(id))
		 {
			 wishListId.add(item.getWishlistId()) ;
		 }
	 }
	 for(Integer wishList:wishListId)
	 {
		System.out.println(wishList);
		 List<WishlistItems> wishListItemsUser= wishListItemsRepo.findByWishlistId(wishList);
		 if(wishListItemsUser!=null)
		 {
			 for(WishlistItems wishListItems:wishListItemsUser)
			 {
		Product product=new Product();
		product=productsService.getProductsDetails(wishListItems.getProductId());
		EntireWishListDetails wishListItem=new EntireWishListDetails();
		wishListItem.setEmailId(id);
		wishListItem.setProductId(wishListItems.getProductId());
		wishListItem.setProductImage(product.getProductImage());
		wishListItem.setProductName(product.getProductName());
		wishListItem.setPrice(product.getProduct_price());
		totalWishList.add(wishListItem);
		 }
		 }
	 }
	 return totalWishList;
	
	}
	
	public int checkIfWishListexists(String id)
	{
		List<ProductWishlist> AllCartDetails=productWishListRepository.findAll();
		List<Integer> wishListId=new ArrayList<Integer>();
		int wishList=0;
		List<EntireWishListDetails> totalWishList=new ArrayList<EntireWishListDetails>();
		 for(ProductWishlist item:AllCartDetails)
		 {
			 if(item.getEmailId().equalsIgnoreCase(id))
			 {
				 wishListId.add(item.getWishlistId()) ;
				 wishList=item.getWishlistId();
			 }
		 }
		 return wishList;
	}

	public int deleteFromWishList(ArrayList<Object> cart) {
		List<ProductWishlist> AllCartDetails=productWishListRepository.findAll();
		List<Integer> wishListId=new ArrayList<Integer>();
		int count=0;
		List<EntireWishListDetails> totalWishList=new ArrayList<EntireWishListDetails>();
		 for(ProductWishlist item:AllCartDetails)
		 {
			 if(item.getEmailId().equalsIgnoreCase(cart.get(1).toString()))
			 {
				 wishListId.add(item.getWishlistId()) ;
			 }
		 }
		 for(Integer wishList:wishListId)
		 {
			 List<WishlistItems> wishListItemsUser= wishListItemsRepo.findByWishlistId(wishList);
			 if(wishListItemsUser!=null)
			 {
				 for(WishlistItems wishListItems:wishListItemsUser)
				 {
			if(wishListItems.getProductId()==Integer.parseInt(cart.get(0).toString()))
			{
				count=count+(wishListItemsRepo.deleteAllByWishlistIdAndProductId(wishListItems.getWishlistId(),wishListItems.getProductId()));
//				count=count+(productWishListRepository.deleteAllByWishlistId(wishListItems.getProductId()));
			}
			 }
			 }
		
		 }
		 return count;
	}
	
	
}

