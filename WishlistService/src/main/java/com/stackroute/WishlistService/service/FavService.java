package com.stackroute.WishlistService.service;

import java.util.List;



import com.stackroute.WishlistService.entity.WishList;

import com.stackroute.WishlistService.exception.StockAlreadyExistException;
import com.stackroute.WishlistService.exception.StockNotFoundInWishListException;
import com.stackroute.WishlistService.exception.UserNotFoundException;


public interface FavService {
 
//    List<WishList> getAll();
 
    WishList addStockToFavList(WishList newStock) throws StockAlreadyExistException;
    List<WishList> getUserByUsername(String username)throws UserNotFoundException;
     void deleteEntityById(Long id); 
//    String deleteStock(long favId) throws StockNotFoundInWishListException;
 }