package com.stackroute.WishlistService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.WishlistService.exception.StockAlreadyExistException;
import com.stackroute.WishlistService.exception.StockNotFoundInWishListException;
import com.stackroute.WishlistService.exception.UserNotFoundException;
import com.stackroute.WishlistService.entity.WishList;
import com.stackroute.WishlistService.ResponseHandler.ResponseHandler;
import com.stackroute.WishlistService.service.FavService;
import com.stackroute.WishlistService.service.FavServiceImpl;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
 
@RestController
//@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/wishlist")
public class FavController {
 
	@Autowired
	private FavServiceImpl favServiceImpl;
	
	@PostMapping("/add")
	public ResponseEntity<?> addTofavList(@RequestBody WishList newStock) throws StockAlreadyExistException{
		return ResponseEntity.status(HttpStatus.OK).body(this.favServiceImpl.addStockToFavList(newStock));
	}
	
	
	@DeleteMapping("/delete/{id}")
    public void deleteEntitiesByUsernameAndSymbol(@PathVariable Long id) {
		favServiceImpl.deleteEntityById(id);
    }
	
//	@DeleteMapping("/delete/{userId}")
//	public ResponseEntity<?> removeFromFavList(@PathVariable Long userId) throws StockNotFoundInWishListException{
//		return ResponseEntity.status(HttpStatus.OK).body(this.favServiceImpl.deleteStock(userId));
//	}
	
//	@GetMapping("/view")
//	public ResponseEntity<?> viewAllStock() {
//        List<WishList> favorites = favServiceImpl.getAll();
//
//        if (favorites.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No favorites found for user with ID: " );
//        } else {
//            return ResponseEntity.status(HttpStatus.OK).body(favorites);
//        }
//    }
	
	 @GetMapping("/getByUsername/{username}")
	    public ResponseEntity<List<WishList>> getFavByUsername(@PathVariable("username") String username) throws UserNotFoundException {
	        List<WishList> alldata = favServiceImpl.getUserByUsername(username);
	        if (alldata.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	            return new ResponseEntity<>(alldata, HttpStatus.OK);
	        }
	    }
}