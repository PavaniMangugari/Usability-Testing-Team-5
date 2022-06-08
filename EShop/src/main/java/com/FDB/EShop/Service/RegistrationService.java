package com.FDB.EShop.Service;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FDB.EShop.model.Category;
import com.FDB.EShop.model.CityDetails;
import com.FDB.EShop.model.DealItems;
import com.FDB.EShop.model.Deals;
import com.FDB.EShop.model.EntireDealItems;
import com.FDB.EShop.model.EntireUser;
import com.FDB.EShop.model.Product;
import com.FDB.EShop.model.Shippingaddress;
import com.FDB.EShop.model.User;
import com.FDB.EShop.repository.CategoryRepository;
import com.FDB.EShop.repository.CityDetailsRepository;
import com.FDB.EShop.repository.DealItemsRepository;
import com.FDB.EShop.repository.DealsRepository;
import com.FDB.EShop.repository.RegistrationRepository;
import com.FDB.EShop.repository.ShippingRepository;
import com.FDB.EShop.repository.UserRegistrationRepository;

@Service
@Transactional
public class RegistrationService {
	@Autowired
	private UserRegistrationRepository repository;
//	private RegistrationRepository repository;
	
	@Autowired
	private ShippingRepository shippingRepo;
	
	@Autowired 
	private CityDetailsRepository cityRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private DealsRepository dealRepo;
	
	@Autowired
	private DealItemsRepository dealItemRepo;
	
	@Autowired
	private ProductsService productService;
	
	public EntireUser saveUser(EntireUser user)
	{
	User userProfile=new User();
	User newUser=new User();
	int count=0;
	EntireUser entireUser=new EntireUser();
	userProfile.setFirstName(user.getFirstName());
	userProfile.setLastName(user.getLastName());
	userProfile.setPassword(user.getPassword());
	userProfile.setPhoneNumber(user.getPhoneNumber());
	userProfile.setEmailId(user.getEmailId());
	newUser=repository.save(userProfile);
	Shippingaddress shipping=new Shippingaddress();
	Shippingaddress newShipping=new Shippingaddress();
	shipping.setPinCode(user.getPinCode());
	shipping.setHouseNumber(user.getHouseNumber());
	shipping.setStreetName(user.getStreetName());	
	shipping.setEmailId(user.getEmailId());
	newShipping=shippingRepo.save(shipping);
	System.out.println("to save pincode"+ user.getPinCode());
List<CityDetails> cities=cityRepo.findAllByPincode(user.getPinCode());
for(CityDetails city:cities)
{
	if(city.getPinCode()==user.getPinCode())
	{
		count++;
	}
}
if(count==0)
{
	CityDetails city=new CityDetails();
	city.setPinCode(user.getPinCode());
	city.setCity(user.getCity());
	city.setState(user.getState());
	cityRepo.save(city);
}
else
{
	cityRepo.userAddressUpdate(user.getCity(),user.getState(),user.getPinCode());
}
//else
//{
//	cityRepo.deleteExistingPincode(user.getPinCode());
//	CityDetails city=new CityDetails();
//	city.setPinCode(user.getPinCode());
//	city.setCity(user.getCity());
//	city.setState(user.getState());
//	cityRepo.save(city);
//}

	
	entireUser.setFirstName(newUser.getFirstName());
	entireUser.setLastName(newUser.getLastName());
	entireUser.setPassword(newUser.getPassword());
	entireUser.setPhoneNumber(newUser.getPhoneNumber());
	entireUser.setPinCode(newShipping.getPinCode());
	entireUser.setHouseNumber(newShipping.getHouseNumber());
	entireUser.setStreetName(newShipping.getStreetName());	
	entireUser.setCity(user.getCity());
	entireUser.setState(user.getState());
	entireUser.setPinCode(user.getPinCode());
	
	return entireUser;
	}
	
	
//	public int saveAddress(EntireUser user)
//	{
//		
//		
//		CityDetails city=new CityDetails();
//		city.setPinCode(user.getPinCode());
//		city.setCity(user.getCity());
//		city.setState(user.getState());
//		System.out.println("update coty"+city.getCity());
//		System.out.print(city.getState());
//		System.out.println(city.getPinCode());
//		cityRepo.deleteExistingPincode(city.getPinCode());
//		cityRepo.save(city);
//		return 1;
//	}
			
	public EntireUser getUserByEmailId(String emailId)
	{
		
		int count=0;
		User user= repository.findByEmailId(emailId);
		EntireUser entireUser = null;
		if(user!=null)
		{
	entireUser=new EntireUser();
		entireUser.setEmailId(user.getEmailId());
		entireUser.setFirstName(user.getFirstName());
		entireUser.setLastName(user.getLastName());
		entireUser.setPassword(user.getPassword());
		entireUser.setPhoneNumber(user.getPhoneNumber());
		Shippingaddress shipping=shippingRepo.findByEmailId(emailId);
		entireUser.setPinCode(shipping.getPinCode());
		entireUser.setHouseNumber(shipping.getHouseNumber());
		entireUser.setStreetName(shipping.getStreetName());
		System.out.println(entireUser.getPinCode());
		
		List<CityDetails> cities=cityRepo.findAll();
		for(CityDetails city:cities)
		{
			System.out.println("city .pincode"+city.getPinCode());
			if(city.getPinCode()==entireUser.getPinCode())
			{
				
				
				System.out.println("city "+city.getCity());
				entireUser.setCity(city.getCity());
				entireUser.setPinCode(city.getPinCode());
				entireUser.setState(city.getState());
			}
		}
		
		
		}
		return entireUser;
		
	}
	
	public EntireUser fetchUserByEmailIdAndPassword(String emailId, String password)
	{

		EntireUser entireUser=new EntireUser();
		User user= repository.findByEmailIdAndPassword(emailId, password);
		Shippingaddress shipping=shippingRepo.findByEmailId(emailId);
		CityDetails cityDetails=cityRepo.findByPinCode(shipping.getPinCode()); 
		entireUser.setEmailId(user.getEmailId());
		entireUser.setFirstName(user.getFirstName());
		entireUser.setLastName(user.getLastName());
		entireUser.setPassword(user.getPassword());
		entireUser.setPhoneNumber(user.getPhoneNumber());
		entireUser.setPinCode(shipping.getPinCode());
		entireUser.setHouseNumber(shipping.getHouseNumber());
		entireUser.setStreetName(shipping.getStreetName());
		entireUser.setCity(cityDetails.getCity());
		entireUser.setState(cityDetails.getState());
		return entireUser;
		
	}

	public EntireUser updateUserAddress(ArrayList<Object> details) {
		Shippingaddress shipping=shippingRepo.updateUser(details.get(0).toString(),details.get(1).toString(),details.get(2).toString(),Integer.parseInt(details.get(5).toString()));
		CityDetails cityDetails=cityRepo.updateUser(details.get(3).toString(), details.get(4).toString(),Integer.parseInt(details.get(5).toString()) );
	EntireUser entireUser=new EntireUser();
	entireUser.setPinCode(shipping.getPinCode());
	entireUser.setHouseNumber(shipping.getHouseNumber());
	entireUser.setStreetName(shipping.getStreetName());
	entireUser.setCity(cityDetails.getCity());
	entireUser.setState(cityDetails.getState());
	return entireUser;
	}
	public EntireUser updateUser(EntireUser user)
	{
		System.out.println("user......getstate"+user.getState());
		System.out.println("user......getcity"+user.getCity());
//		saveAddress(user);
	return saveUser(user);
	}
	
	public List<Category> getAllCategoriesForUser()
	{
		return categoryRepo.findAll();
	}
	
	
	public List<Deals> getAllDealsForUser()
	{
		return dealRepo.findAll();
	}

	public List<EntireDealItems> getAllDealItems(int dealId)
	{
		List<EntireDealItems> allDealItems=new ArrayList<EntireDealItems>();
		List<DealItems> dealItems= dealItemRepo.findByDealId(dealId);
		for(DealItems deal:dealItems)
		{
			EntireDealItems tempDealItem=new EntireDealItems();
			tempDealItem.setDealId(dealId);
			Product product=productService.getProductsDetails(deal.getProductId());
			tempDealItem.setCategoryId(product.getCategoryId());
			tempDealItem.setProduct_original_price(product.getProduct_original_price());
			tempDealItem.setProduct_price(product.getProduct_price());
			tempDealItem.setProduct_rating(product.getProduct_rating());
			tempDealItem.setProductColor(product.getProductColor());
			tempDealItem.setProductDescription(product.getProductDescription());
			tempDealItem.setProductImage(product.getProductImage());
			tempDealItem.setProductName(product.getProductName());
			allDealItems.add(tempDealItem);
			
		}
		return allDealItems;
	}
	
}



