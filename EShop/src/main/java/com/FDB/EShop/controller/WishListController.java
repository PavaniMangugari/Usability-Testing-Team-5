package com.FDB.EShop.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.FDB.EShop.model.CartProductDetails;
import com.FDB.EShop.model.EntireWishListDetails;
import com.FDB.EShop.model.Product;
import com.FDB.EShop.model.ProductCart;
import com.FDB.EShop.model.ProductWishlist;
import com.FDB.EShop.model.User;
import com.FDB.EShop.model.WishlistItems;
import com.FDB.EShop.Service.ProductsService;
import com.FDB.EShop.Service.WishListService;

@CrossOrigin(origins = "*")
@RestController

public class WishListController {
	@Autowired
	WishListService wishListService;
	
	@Autowired
	ProductsService productsService;
	
	

	@PostMapping("/saveToWishList")
	 public boolean saveToWishList(@RequestBody ArrayList<Object> details) {
	        ResponseEntity responseEntity;
	        boolean status=false;
	        try {
	           ProductWishlist wishlist = new ProductWishlist();
	           System.out.println(details.get(1).toString());
	           wishlist.setEmailId(details.get(1).toString());
	         //  wishlist.setWishlistId(1);
	           int wishListId=0;
	           int NewWishListId=0;
	           int userWishListId=wishListService.checkIfWishListexists(details.get(1).toString());
	           if(userWishListId==0)
	           {
	            wishListId=wishListService.getWishListId();
	           NewWishListId=wishListId+1;
	           }
	           else
	           {
	        	   NewWishListId=userWishListId;
	           }
	          wishlist.setWishlistId(NewWishListId);
	        	responseEntity = new ResponseEntity<ProductWishlist>(wishListService.saveToWishList(wishlist), HttpStatus.CREATED);
	        	//int wishListId=wishListService.getWishListId();
	        	WishlistItems wishListItems=new WishlistItems();
	        	wishListItems.setProductId(Integer.parseInt(details.get(0).toString()));
	        	wishListItems.setWishlistId(NewWishListId);
	        	wishListItems.setProductType("shirt");
	        	responseEntity = new ResponseEntity<WishlistItems>(wishListService.saveToWishListItems(wishListItems), HttpStatus.CREATED);
	        	status=true;
	            System.out.println("Added to wishlist");
	          	          
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("error while adding to cart");
	            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
	             ResponseEntity.status(HttpStatus.CONFLICT).body("Error");
	           	        }
	       
	        return status;
	        
	    }

		@PostMapping("/deleteItemFromWishList")
		 public int deleteItemFromCart(@RequestBody ArrayList<Object> cart) {
			 int status=0;
			 WishlistItems wishListItems=new WishlistItems();
		        try {
		        status=  wishListService.deleteFromWishList(cart);
		            System.out.println("Deleted From cart");
		          	          
		        } catch (Exception e) {
		            e.printStackTrace();
		            System.out.println("error while deleting from to cart");
		          
		          return 0;
		           	        }
		       
		       return status;
		        
		    }

		@PostMapping("/retrieveWishList")
		 public List<EntireWishListDetails> retrieveWishList(@RequestBody String name) {
			 List<EntireWishListDetails> cartDetails=new ArrayList<>();
			List<EntireWishListDetails>userCartDetails= wishListService.retrieveWishListForUser(name); 

			return userCartDetails;
		    }


	


}
