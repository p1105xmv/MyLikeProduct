package com.myProduct.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProduct.Model.Product;
import com.myProduct.Model.ProductRepository;
import com.myProduct.Model.Userinfo;
import com.myProduct.Model.UsersRepository;

@Service
public class ProductService {
	@Autowired
    private ProductRepository productRepo;
	
	@Autowired
    private UsersRepository userRepo;
	
	public Product findProductByName(String name) {
		return productRepo.findByProductName(name);
	}
	
	public void saveProduct(String productName,Integer price, double feeRate, Integer userid) {
			Product newProduct = new Product();
			newProduct.setProductName(productName);
			newProduct.setPrice(price);
			newProduct.setFeeRate(feeRate);
			Userinfo userinfo = userRepo.findByUserid(userid);
			newProduct.setUserinfo(userinfo);
		    productRepo.save(newProduct);	
	}
	
	public Product findProductById(Integer productid) {
		return productRepo.findByProductid(productid);
	}
	
	

}
