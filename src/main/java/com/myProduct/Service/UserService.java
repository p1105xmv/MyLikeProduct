package com.myProduct.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProduct.Model.Userinfo;
import com.myProduct.Model.UsersRepository;

@Service
public class UserService {
	@Autowired
    private UsersRepository userRepo;
	
	public Userinfo findUserById(Integer userid) {
	   return userRepo.findByUserid(userid);
	}
	
	public Userinfo findUserByName(String name) {
		return userRepo.findByUserName(name);
	}
	
	public void saveUserinfo(String username,String email) {
		Userinfo user = userRepo.findByUserName(username);
		if(user==null) {
			Userinfo newUser = new Userinfo();
		    newUser.setUserName(username);;
		    newUser.setEmail(email);
		    userRepo.save(newUser);
		}
	}
	
	

}
