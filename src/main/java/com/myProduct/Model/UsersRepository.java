package com.myProduct.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Userinfo, Integer> {
	Userinfo findByUserName(String userName);

	Userinfo findByUserid(Integer userid);

}


