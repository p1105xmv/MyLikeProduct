package com.myProduct.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myProduct.Model.Product;
import com.myProduct.Service.LikeListService;
import com.myProduct.Service.ProductService;


@Controller
public class PageController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private LikeListService likeService;
	
	
	@GetMapping("/")
	public String test() {
		return "Test";
	}
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/create")
	public String insertData() {
		return "create";
	}
	
	@GetMapping("/read")
	public String search() {
		return "read";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "delete";
	}
	
	//開啟產品資訊小筐
	@GetMapping("/productInfo/{productId}")
	private String getProductInfoByName(@PathVariable("productId") Integer productId, Model model) {
		Product product = productService.findProductById(productId);
		Integer productid = product.getProductid();
		model.addAttribute("productid", productid);
		return "productInfo";
	}
	
	

}