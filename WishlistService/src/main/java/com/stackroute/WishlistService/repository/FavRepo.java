package com.stackroute.WishlistService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stackroute.WishlistService.entity.WishList;


public interface FavRepo extends JpaRepository<WishList, Long>{
	List<WishList> findByUserId(Long userId);
	Optional<WishList> findBySymbol(String symbol);
	List<WishList> findByUsername(String username);
//   
//@Query(value ="SELECT *FROM favstock WHERE user_name = ?1" ,nativeQuery = true)
//List<WishList> findAllByUsername(@Param("username")String userName);
}
