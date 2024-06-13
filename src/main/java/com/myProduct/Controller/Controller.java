package com.myProduct.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myProduct.Model.LikeList;
import com.myProduct.Model.LikeListDTO;
import com.myProduct.Model.Product;
import com.myProduct.Model.Userinfo;
import com.myProduct.Service.LikeListService;
import com.myProduct.Service.ProductService;
import com.myProduct.Service.UserAccountService;
import com.myProduct.Service.UserService;

@RestController
public class Controller {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserAccountService accService;
	
	@Autowired
	private LikeListService likeService;
	
	@GetMapping("/userinfo/{userid}")
	private Userinfo testShowUser(@PathVariable("userid")Integer userid) {
		Userinfo user = uService.findUserById(userid);
		return user;
	}
	
	//新增喜好的金融商品
	@PostMapping("/submitForm")
    private String submitForm(@RequestBody LikeListDTO DTO) {
		uService.saveUserinfo(DTO.getUserName(), DTO.getEmail());
		
		Userinfo user = uService.findUserByName(DTO.getUserName());
		Integer userid = user.getUserid();
		
		productService.saveProduct(DTO.getProductName(), DTO.getPrice(), DTO.getFeeRate(), userid);
		
		Product product = productService.findProductByName(DTO.getProductName());
		Integer productid = product.getProductid();
		
		accService.saveUserAccount(DTO.getAccount(), userid);
		likeService.saveLikeList(DTO.getOrderQuantity(), productid, DTO.getAccount());
		    
	    System.out.println("Received form data: " + DTO);
	    return "Form submitted successfully";
    }
	
	//查詢喜好商品清單
	@GetMapping("/likelist/{username}")
	private List<LikeList> findMyLikeList(@PathVariable("username")String username) {
		List<LikeList> list = likeService.findLikeListByUsername(username);
		return list;
	}
	
	//查詢產品資訊
	@GetMapping("/getProductInfo/{productId}")
	private Product findProductByName(@PathVariable("productId") Integer productId) {
		Product product = productService.findProductById(productId);
		return product;
	}
	
	//刪除喜好商品
	@GetMapping("/deleteLikeList/{listid}")
	private void deleteLikeList(@PathVariable("listid") Integer listid) {
		likeService.deleteLikeListById(listid);
		System.out.println("delete successfully!");
	}
	

}
