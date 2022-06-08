package com.FDB.EShop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FDB.EShop.model.CartItems;
import com.FDB.EShop.model.EntireShoppingCart;
import com.FDB.EShop.model.EntireWishListDetails;
import com.FDB.EShop.model.Product;
import com.FDB.EShop.model.ProductCart;
import com.FDB.EShop.model.ProductWishlist;
import com.FDB.EShop.model.User;
import com.FDB.EShop.model.WishlistItems;
import com.FDB.EShop.Service.ProductCartService;
import com.FDB.EShop.Service.ProductsService;
import com.FDB.EShop.Service.RegistrationService;

@CrossOrigin(origins = "*")
@RestController
public class ProductCartController {

	@Autowired
	private ProductCartService productCartService;
	
	@Autowired
	private ProductsService productsService;
	
	
	@PostMapping("/saveToCart")
	 public boolean saveToCart(@RequestBody ArrayList<Object> details) {
	        ResponseEntity responseEntity;
	        boolean status=false;
	        try {
		           ProductCart productCart = new ProductCart();
		           System.out.println(details.get(1).toString());
		           productCart.setEmailId(details.get(1).toString());
		          int cartId=0;
		          int newCartId=0;
		          int userCartId=productCartService.getcartIdIfUserHadCart(productCart.getEmailId());
		        if(userCartId==0)
		        {
		          cartId=productCartService.getCartId();
		          if(cartId!=0)
		          {
		          newCartId=cartId+1;
		          }
		          else
		          {
		        	  newCartId=1;  
		          }
		          
		         productCart.setCartId(newCartId);
		        }
		        else
		        {
		        	productCart.setCartId(userCartId);
		        	newCartId=userCartId;
		        }
		        	responseEntity = new ResponseEntity<ProductCart>(productCartService.saveToCart(productCart), HttpStatus.CREATED);
		        CartItems cartItems=new CartItems();
		        cartItems.setProductId(Integer.parseInt(details.get(0).toString()));
		        cartItems.setCartId(newCartId);
		       // cartItems.setAvailable(true);
		        cartItems.setCount(1);
		        Product product=productsService.getProductsDetails(cartItems.getProductId());
		        cartItems.setPrice(product.getProduct_price());
		       responseEntity = new ResponseEntity<CartItems>(productCartService.saveToCartItems(cartItems), HttpStatus.CREATED);
		       status=true;
		            System.out.println("Added to cart");
		          	          
		        } catch (Exception e) {
		            e.printStackTrace();
		            System.out.println("error while adding to cart");
		            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		             ResponseEntity.status(HttpStatus.CONFLICT).body("Error");
		           	        }
		       
		        return status;
	    }
	
	@PostMapping("/saveToMultipleCountToCart")
	 public ResponseEntity<?> saveToMultipleCountToCart(@RequestBody ArrayList<Object> details) {
	        ResponseEntity responseEntity;
	        try {
		           ProductCart productCart = new ProductCart();
		           System.out.println(details.get(1).toString());
		           productCart.setEmailId(details.get(1).toString());
		           int cartId=0;
			          int newCartId=0;
			          int userCartId=productCartService.getcartIdIfUserHadCart(productCart.getEmailId());
			        if(userCartId==0)
			        {
			          cartId=productCartService.getCartId();
			          if(cartId!=0)
			          {
			          newCartId=cartId+1;
			          }
			          else
			          {
			        	  newCartId=1;  
			          }
			          
			         productCart.setCartId(newCartId);
			        }
			        else
			        {
			        	productCart.setCartId(userCartId);
			        	newCartId=userCartId;
			        }
		        	responseEntity = new ResponseEntity<ProductCart>(productCartService.saveToCart(productCart), HttpStatus.CREATED);
		        CartItems cartItems=new CartItems();
		        cartItems.setProductId(Integer.parseInt(details.get(0).toString()));
		        cartItems.setCartId(newCartId);
		        cartItems.setCount(Integer.parseInt(details.get(2).toString()));
		        Product product=productsService.getProductsDetails(cartItems.getProductId());
		        cartItems.setPrice( (cartItems.getCount())*(product.getProduct_price()));
		       responseEntity = new ResponseEntity<CartItems>(productCartService.saveToCartItems(cartItems), HttpStatus.CREATED);
		        	
		            System.out.println("Added to cart");
		          	          
		        } catch (Exception e) {
		            e.printStackTrace();
		            System.out.println("error while adding to cart");
		            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error");
		           	        }
		       
		        return new ResponseEntity<>("Successfully added to cart", HttpStatus.CREATED);
	    }
	
	
	
	@PostMapping("/deleteItemFromCart")
	 public int deleteItemFromCart(@RequestBody ArrayList<Object> cart) {
		 int status=0;
	        try {
	        status=  productCartService.deleteFromCart(cart);
	            System.out.println("Deleted From cart");
	          	          
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("error while deleting from to cart");
	          
	          return 0;
	           	        }
	       
	       return status;
	        
	    }
	
	
	
	
	@PostMapping("/retrieveCart")
	 public List<EntireShoppingCart> retrieveCart(@RequestBody String name) {
		
		 List<EntireShoppingCart> cartDetails=new ArrayList<>();
			List<EntireShoppingCart>userCartDetails= productCartService.retrieveCartDetailsForUser(name);
			return userCartDetails;
	    }
	
	
	@PostMapping("/retrieveCartIncludingPrice")
	 public List<EntireShoppingCart> retrieveCartIncludingPrice(@RequestBody String name) {
		int cartPrice=0;
		 List<EntireShoppingCart> cartDetails=new ArrayList<>();
			List<EntireShoppingCart>userCartDetails= productCartService.retrieveCartDetailsForUser(name);
			for(EntireShoppingCart cart:userCartDetails)
			{
				cartPrice=cartPrice+cart.getPrice();
			}
			for(EntireShoppingCart cart:userCartDetails)
			{
				cart.setCartPrice(cartPrice);
			}
			return userCartDetails;
		
	    }

	@PostMapping("/cartPrice")
	 public int cartPrice(@RequestBody String name) {
		int cartPrice=0;
		 List<EntireShoppingCart> cartDetails=new ArrayList<>();
			List<EntireShoppingCart>userCartDetails= productCartService.retrieveCartDetailsForUser(name);
			for(EntireShoppingCart cart:userCartDetails)
			{
				cartPrice=cartPrice+cart.getPrice();
			}
			for(EntireShoppingCart cart:userCartDetails)
			{
				cart.setCartPrice(cartPrice);
			}
			return cartPrice;
		
	    }

	
	
}




