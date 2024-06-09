package com.stackroute.StockService.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface StockService {

	public ResponseEntity<?> getStocks();
	
	public ResponseEntity<?> getStocksByCountryName(String countryName);
}
