package com.myProduct.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProduct.Model.UserAccount;
import com.myProduct.Model.UserAccountRepository;
import com.myProduct.Model.Userinfo;
import com.myProduct.Model.UsersRepository;

@Service
public class UserAccountService {
	@Autowired
    private UserAccountRepository accRepo;
	
	@Autowired
    private UsersRepository userRepo;
	
	public void saveUserAccount(String account,Integer userid) {
		UserAccount userAcc = accRepo.findByAccount(account);
		if(userAcc==null) {
			UserAccount newUserAcc = new UserAccount();
			newUserAcc.setAccount(account);
			Userinfo userinfo = userRepo.findByUserid(userid);
			newUserAcc.setUserinfo(userinfo);
		    accRepo.save(newUserAcc);
		}
	}
	
	

}
