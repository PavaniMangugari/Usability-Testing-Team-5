package com.FDB.EShop.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FDB.EShop.model.Product;

import com.FDB.EShop.model.User;
import com.FDB.EShop.repository.ProductsRepository;
import com.FDB.EShop.repository.RegistrationRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository repository;
	
	public List<Product> getAllProducts(int categoryId)
	{
		return repository.findByCategoryId(categoryId); 
	}
	

	public Product getProductsDetails(int productId)
	{
		return repository.findByProductId(productId);
	}
	

	public List<Product> findProductsByName(String productName)
	{
		return repository.findByProductName(productName);
	}
	
	
	
	
	
}
