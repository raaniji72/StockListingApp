package com.stackroute.WishlistService.exception;

public class StockAlreadyExistException extends RuntimeException {
	public StockAlreadyExistException(String message) {
		super(message);
	}
}
