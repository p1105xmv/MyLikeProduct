package com.myProduct.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

	UserAccount findByAccount(String account);

}


