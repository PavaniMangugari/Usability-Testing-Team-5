package com.FDB.EShop.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FDB.EShop.model.CartItems;
import com.FDB.EShop.model.EntireShoppingCart;
import com.FDB.EShop.model.EntireWishListDetails;
import com.FDB.EShop.model.Product;
import com.FDB.EShop.model.ProductCart;
import com.FDB.EShop.model.ProductWishlist;
import com.FDB.EShop.model.WishlistItems;
import com.FDB.EShop.repository.ProductCartRepository;
import com.FDB.EShop.repository.ProuctCartItemsRepository;

@Service
@Transactional
public class ProductCartService {

	

	
	@Autowired
	private ProductCartRepository productCartRepository;
	
	@Autowired
	private ProuctCartItemsRepository cartItemsRepo;
	
	@Autowired
	private ProductsService productsService;
	
	
	public ProductCart saveToCart(ProductCart cart)
	{
	return productCartRepository.save(cart);
		
	}

public Integer getCartId()
{
	int cartId=0;
	Integer id=(productCartRepository.getCartId());
	if(id!=null)
	{
		cartId=id;
	}else
	{
		cartId=1;
	}
	return cartId;
}

public CartItems saveToCartItems(CartItems cartItems)
{
	return cartItemsRepo.save(cartItems);
}
	
	
	public int deleteFromCart(ArrayList<Object>  cart)
	{
	List<ProductCart> productCart=productCartRepository.findAll();
	List<Integer> cartId=new ArrayList<Integer>();
	int count=0;
	int CartIdValue = 0;
	int cartItemsForUser=0;
	int cartPrice=0;
	 for(ProductCart item:productCart)
	 {
		 if(item.getEmailId().equalsIgnoreCase(cart.get(1).toString()))
		 {
			 cartId.add(item.getCartId()) ;
			 CartIdValue=item.getCartId();
		 }
	 }
	 for(Integer id:cartId)
	 {
		 List<CartItems> cartItemsUser= cartItemsRepo.findByCartId(id);
		 if(cartItemsUser!=null)
		 {
			 for(CartItems cartItems:cartItemsUser)
			 {
		if(cartItems.getProductId()!=Integer.parseInt(cart.get(0).toString()))
		{
			cartPrice=cartPrice+cartItems.getPrice();
			
		}
		
		 }
		 }
	
	 }
	 for(Integer id:cartId)
	 {
		 List<CartItems> cartItemsUser= cartItemsRepo.findByCartId(id);
		 if(cartItemsUser!=null)
		 {
			 for(CartItems cartItems:cartItemsUser)
			 {
		if(cartItems.getProductId()==Integer.parseInt(cart.get(0).toString()))
		{
			count=count+(cartItemsRepo.deleteByCartIdAndProductId(cartItems.getCartId(),cartItems.getProductId()));
			
		}
		
		 }
		 }
	
	 }
	 
		List<ProductCart> userCartList=productCartRepository.findAll();
		 for(ProductCart item:userCartList)
		 {
			 if(item.getEmailId().equalsIgnoreCase(cart.get(1).toString()))
			 {
				 cartItemsForUser++;
				
			 }
		 }
		 
		
	 
		return count;
	}
	
	
	public int deleteFromCartRepo(String emailId,int productId)
	{
	List<ProductCart> productCart=productCartRepository.findAll();
	List<Integer> cartId=new ArrayList<Integer>();
	int count=0;
	int CartIdValue = 0;
	int cartItemsForUser=0;
	int cartPrice=0;
	 for(ProductCart item:productCart)
	 {
		 if(item.getEmailId().equalsIgnoreCase(emailId))
		 {
			 cartId.add(item.getCartId()) ;
			 CartIdValue=item.getCartId();
		 }
	 }
	 for(Integer id:cartId)
	 {
		 List<CartItems> cartItemsUser= cartItemsRepo.findByCartId(id);
		 if(cartItemsUser!=null)
		 {
			 for(CartItems cartItems:cartItemsUser)
			 {
		if(cartItems.getProductId()!=(productId))
		{
			cartPrice=cartPrice+cartItems.getPrice();
			
		}
		
		 }
		 }
	
	 }
	 for(Integer id:cartId)
	 {
		 List<CartItems> cartItemsUser= cartItemsRepo.findByCartId(id);
		 if(cartItemsUser!=null)
		 {
			for(CartItems cartItems:cartItemsUser) 
			{
		if(cartItems.getProductId()==productId)
		{
			count=count+(cartItemsRepo.deleteByCartId(cartItems.getCartId()));
			
		}
		
		 }
		 }
	
	 }
	 
		List<ProductCart> userCartList=productCartRepository.findAll();
		 for(ProductCart item:userCartList)
		 {
			 if(item.getEmailId().equalsIgnoreCase(emailId))
			 {
				 cartItemsForUser++;
				
			 }
		 }
		 
		
	 
		return count;
	}
	
	

	public List<EntireShoppingCart> retrieveCartDetailsForUser(String id)
	{
	List<ProductCart> AllCartDetails=productCartRepository.findAll();
	List<ProductCart> userCartDetails = new ArrayList<>();
	List<CartItems> cartItems=cartItemsRepo.findAll();
	int cartPrice=0;
	int cartId=0;
	String mailId=null;
	int cartCount=0;
	
	List<EntireShoppingCart> entireShoppingCart=new ArrayList<EntireShoppingCart>();
	
	 for(ProductCart item:AllCartDetails)
	 {
		 if(item.getEmailId().equalsIgnoreCase(id))
		 {
			 userCartDetails.add(item) ;
		
			mailId=item.getEmailId();
			cartId=item.getCartId();
		 }
	 }
	 cartItemsRepo.getCartItemsCount(cartId);
	
	 for(ProductCart cart:userCartDetails)
	 {
		 List<CartItems> cartItemUser=cartItemsRepo.findByCartId(cart.getCartId());
		 if(cartItemUser!=null)
		 {
			 for(CartItems cartItem:cartItemUser)
			 {
		 EntireShoppingCart item=new EntireShoppingCart();
		 item.setProductId(cartItem.getProductId());
		 item.setPrice(cartItem.getPrice());
		 item.setCartId(cartItem.getCartId());
		 item.setCount(cartItem.getCount());
		Product product=productsService.getProductsDetails(cartItem.getProductId());
		item.setCategoryId(product.getCategoryId());
		item.setProduct_original_price(product.getProduct_original_price());
		item.setProduct_price(product.getProduct_price());
		item.setProduct_rating(product.getProduct_rating());
		item.setProductColor(product.getProductColor());
		item.setProductDescription(product.getProductDescription());
		item.setProductImage(product.getProductImage());
		item.setProductName(product.getProductName());
		 entireShoppingCart.add(item);
			 }
		 }
	 }
	return entireShoppingCart;
	
	}
	
	public int getcartIdIfUserHadCart(String emailId)
	{
		List<ProductCart> AllCartDetails=productCartRepository.findAll();
		List<ProductCart> userCartDetails = new ArrayList<>();

		int cartId=0;

		
		 for(ProductCart item:AllCartDetails)
		 {
			 if(item.getEmailId().equalsIgnoreCase(emailId))
			 {
				
				cartId=item.getCartId();
			 }
		 }
		 return cartId;
		 
	}
	
	
	
}
