package com.myProduct.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProduct.Model.LikeList;
import com.myProduct.Model.LikeListDTO;
import com.myProduct.Model.LikeListRepository;
import com.myProduct.Model.Product;
import com.myProduct.Model.ProductRepository;
import com.myProduct.Model.UserAccount;
import com.myProduct.Model.UserAccountRepository;
import com.myProduct.Model.Userinfo;
import com.myProduct.Model.UsersRepository;

@Service
public class LikeListService {
	@Autowired
    private LikeListRepository likeRepo;
	
	@Autowired
    private ProductRepository productRepo;
	
	@Autowired
    private UserAccountRepository AccRepo;
	
	public void saveLikeList(Integer orderQuantity,Integer productid, String account) {
		LikeList newList = new LikeList();
		Product product = productRepo.findByProductid(productid);
		double totalFee = (product.getPrice())*orderQuantity*(product.getFeeRate());
		Integer totalAmount = (int) ((product.getPrice())*orderQuantity+totalFee);
		UserAccount userAcc = AccRepo.findByAccount(account);
		
		newList.setOrderQuantity(orderQuantity);
		newList.setProduct(product);
		newList.setTotalAmount(totalAmount);
		newList.setTotalFee(totalFee);
		newList.setUserAccount(userAcc);

	    likeRepo.save(newList);
		}
	
	public List<LikeList> findLikeListByUsername(String username){
		List<LikeList> list = likeRepo.findLikeListByUsername(username);
		return list;
	}
	
	public void deleteLikeListById(Integer listid) {
		likeRepo.deleteById(listid);
	}
	
	public LikeList findOneListById(Integer listid) {
		LikeList onelist = likeRepo.findByListid(listid);
		return onelist;
	}
	
	public void updateLikeList(String productName, Integer price, double feeRate,
			String account, Integer orderQuantity, Integer listid) {
		LikeList list = likeRepo.findByListid(listid);
		if(list!=null) {
			Product product = productRepo.findByProductName(productName);
			double totalFee = (product.getPrice())*orderQuantity*(product.getFeeRate());
			Integer totalAmount = (int) ((product.getPrice())*orderQuantity+totalFee);
			UserAccount userAcc = AccRepo.findByAccount(account);
			list.setOrderQuantity(orderQuantity);
			list.setProduct(product);
			list.setTotalFee(totalFee);
			list.setTotalAmount(totalAmount);
			list.setUserAccount(userAcc);
			
			likeRepo.save(list);
		}
	}

}


	
	

