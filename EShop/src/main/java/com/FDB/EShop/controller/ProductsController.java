package com.FDB.EShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.FDB.EShop.model.Product;
import com.FDB.EShop.model.User;
import com.FDB.EShop.repository.ProductsRepository;
import com.FDB.EShop.Service.ProductsService;
import com.FDB.EShop.Service.RegistrationService;

@CrossOrigin(origins = "*")
@RestController

public class ProductsController {


	@Autowired
	private ProductsService productService;
	
	

	//To get specific mobile information based on the productId
	@PostMapping("/get-Product-Details")
	public Product getProductDetails(@RequestBody Product productMobile) throws Exception
	{
		
		return productService.getProductsDetails(productMobile.getProductId());
	}
	
	
	
	//To list down all the mobile products that are available for sale
	@PostMapping("/products-list")
	public List<Product> searchProduct(@RequestBody int categoryId) throws Exception
	{
		System.out.println("check category Id"+categoryId);
		return productService.getAllProducts(categoryId);
	}
	
	
	
}
