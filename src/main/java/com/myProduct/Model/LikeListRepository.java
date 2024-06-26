package com.myProduct.Model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LikeListRepository extends JpaRepository<LikeList, Integer> {

	LikeList findByListid(Integer listid);
	
	@Query(value = "select L.* from LikeList L left join UserAccount UA on L.account = UA.account\n"
			+ " Left join Userinfo U on UA.userid = U.userid where U.username = :username", nativeQuery = true)
	List<LikeList> findLikeListByUsername(String username);
	
	//這邊設定金融商品名稱不重複
	@Query(value = "select L.* from LikeList L left join Product P on L.productid = P.productid\n"
			+ " where P.product_name = :productName", nativeQuery = true)
	LikeList findLikeListByProductName(String productName);


}


