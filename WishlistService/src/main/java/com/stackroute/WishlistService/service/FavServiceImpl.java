package com.stackroute.WishlistService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.WishlistService.entity.WishList;
import com.stackroute.WishlistService.exception.StockAlreadyExistException;
import com.stackroute.WishlistService.exception.StockNotFoundInWishListException;
import com.stackroute.WishlistService.exception.UserNotFoundException;
import com.stackroute.WishlistService.repository.FavRepo;


@Service
public class FavServiceImpl implements FavService {

	
	@Autowired
	private FavRepo favRepo;
	
	

	@Override
	public WishList addStockToFavList(WishList newStock) throws StockAlreadyExistException {
		// TODO Auto-generated method stub
		Optional<WishList> stock= this.favRepo.findBySymbol(newStock.getSymbol());
		if(stock.isEmpty()) {
			WishList fav=this.favRepo.save(newStock);
			return fav;
		}else {
			throw new StockAlreadyExistException("Stock already is there in wishlist");
		}
	}

//	@Override
//	public String deleteStock(long favId) throws StockNotFoundInWishListException  {
//		
//		Optional<WishList> stock=	 this.favRepo.findById(favId);
//		if(stock.isPresent()) {
//			this.favRepo.deleteById(favId);
//			return "Stock revmoved successfully";
//		}else {
//			throw new StockNotFoundInWishListException("Stock not found");
//		}
//	}

//	@Override
//	public List<WishList> getAll() {
//		// TODO Auto-generated method stub
//		return favRepo.findAll();
//	}
    
	@Override
	public List<WishList> getUserByUsername(String username) throws UserNotFoundException {
        return favRepo.findByUsername(username);
    }
	
	@Override
	public void deleteEntityById(Long favid) {
		favRepo.deleteById(favid);
    }
	
	}