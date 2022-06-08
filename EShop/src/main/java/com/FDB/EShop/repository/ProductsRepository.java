package com.FDB.EShop.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FDB.EShop.model.Product;

public interface ProductsRepository extends JpaRepository<Product,Integer>{

	public List<Product> findByCategoryId(int categoryId);  //to find products based on categoruId
	public Product findByProductId(int productId);  //to find the product details based on product id
	
	
	@Query(value="select * from product where product_name like  %:product_name%", nativeQuery = true)
	public List<Product> findByProductName(@Param("product_name") String product_name); // to find the products with name
	

}
