package com.FDB.EShop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FDB.EShop.Service.RegistrationService;
import com.FDB.EShop.model.EntireUser;
import com.FDB.EShop.model.User;
import com.FDB.EShop.model.Category;
import com.FDB.EShop.model.DealItems;
import com.FDB.EShop.model.Deals;
import com.FDB.EShop.model.EntireDealItems;

@CrossOrigin(origins = "*")
@RestController
public class RegisterUserController {
	@Autowired
	private RegistrationService service;
	
	String activeUser;
	

	@PostMapping("/registerUser")
	public String registerUser(@RequestBody EntireUser entireUser) throws Exception
	{
		String checkEmailId=entireUser.getEmailId();
		if(checkEmailId!=null && !"".equals(checkEmailId))   // to check if user already exists
		{
			EntireUser userObject=service.getUserByEmailId(checkEmailId);
			if(userObject!=null)
			{
				throw new Exception("user with "+checkEmailId +" already exists");   //throws exception
			}
		}
		EntireUser userObject=null;
		userObject=service.saveUser(entireUser);  //saves user
		return "true";
	}
	

	
	@PostMapping("/login")
	public EntireUser loginUser(@RequestBody User user) throws Exception
	{
		String userEmailId=user.getEmailId();
		String userPassword=user.getPassword();
		activeUser=userEmailId;
		EntireUser userObject=null;
		if(userEmailId !=null && userPassword !=null)
		{
			userObject=	service.fetchUserByEmailIdAndPassword(userEmailId , userPassword);   //verifies the credentials
		}
		if(userObject==null)
		{
			throw new Exception("bad credentials");    //throws error if credentials are wrong
		}
		return userObject;
	}
	
	
	@PostMapping("/getCategories")
	public List<Category> getCategories(@RequestBody String name) throws Exception
	{
		
		return service.getAllCategoriesForUser();
	}
	
	@PostMapping("/getDeals")
	public List<Deals> getAllDeals(@RequestBody String name) throws Exception
	{
		
		return service.getAllDealsForUser();
	}
	
	@PostMapping("/getAllDealItems")
	public List<EntireDealItems> getAllDealItems(@RequestBody int dealId) throws Exception
	{
		System.out.println("dealid "+dealId);
		return service.getAllDealItems(dealId);
	}
	
	
	@PostMapping("/retrieveUser")
	public EntireUser retrieveUser(@RequestBody String emailId) throws Exception
	{
		System.out.println(emailId);
		EntireUser userObject=null;
		if(emailId !=null)
		{
			System.out.println("inside not null");
			userObject=	service.getUserByEmailId(emailId);   //verifies the credentials
		}
		if(userObject==null)
		{
			throw new Exception("no user data");    //throws error if credentials are wrong
		}
		return userObject;
	}
	
	@PostMapping("/changeAddress")
	public String changeAddress(@RequestBody ArrayList<Object> details) throws Exception
	{
		EntireUser userObject=null;
		EntireUser updatesUser=new EntireUser();
		EntireUser newUser=null;
		userObject=	service.getUserByEmailId(details.get(0).toString()); 
		User user=new User();
		System.out.println("details.get(0).toString() "+details.get(0).toString());
		updatesUser.setEmailId(userObject.getEmailId());
		updatesUser.setFirstName(userObject.getFirstName());
		updatesUser.setLastName(userObject.getLastName());
		updatesUser.setPassword(userObject.getPassword());
		updatesUser.setPhoneNumber(userObject.getPhoneNumber());
		updatesUser.setHouseNumber(details.get(1).toString());
		updatesUser.setStreetName(details.get(2).toString());
		System.out.println("details.get(2).toString() "+details.get(2).toString());
		
		updatesUser.setCity(details.get(3).toString());
		System.out.println("userObject.getCity()"+userObject.getCity());
		updatesUser.setState(details.get(4).toString());
		updatesUser.setPinCode(Integer.parseInt(details.get(5).toString()));
		newUser=service.updateUser(updatesUser);  //saves user
		
		return "true";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@RequestBody EntireUser user) throws Exception
	{
		
		EntireUser userObject=null;
		EntireUser updatesUser=null;
		userObject=	service.getUserByEmailId(user.getEmailId());  
		user.setPassword(userObject.getPassword());
		userObject.setEmailId(userObject.getEmailId());
		userObject.setFirstName(userObject.getFirstName());
		userObject.setLastName(userObject.getLastName());
		userObject.setPassword(userObject.getPassword());
		userObject.setPhoneNumber(userObject.getPhoneNumber());
		userObject.setHouseNumber(user.getHouseNumber());
		userObject.setStreetName(user.getStreetName());
		userObject.setCity(user.getCity());
		userObject.setState(user.getState());
		userObject.setPinCode(user.getPinCode());
		System.out.println("user.getCity() "+user.getCity());
		
		updatesUser=service.updateUser(user);  //saves user
		return "true";
	}
	

	
}
