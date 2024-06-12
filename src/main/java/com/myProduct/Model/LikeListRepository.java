package com.myProduct.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeListRepository extends JpaRepository<LikeList, Integer> {

	LikeList findByListid(Integer listid);

}


