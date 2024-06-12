package com.myProduct.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByProductid(Integer productid);
	
	Product findByProductName(String name);

}


