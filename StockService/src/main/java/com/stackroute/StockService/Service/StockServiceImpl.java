package com.stackroute.StockService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.StockService.Entity.Data;
import com.stackroute.StockService.Entity.Stock;
import com.stackroute.StockService.Service.StockService;

	@Service
	public class StockServiceImpl implements StockService{
	    private String apiUrl =
	            "https://api.twelvedata.com/stocks?apikey=976f2a60008e44f78544c3c179bcb824&country=India";
	    private String Url =
	            "https://api.twelvedata.com/stocks?apikey=976f2a60008e44f78544c3c179bcb824&country=";

	    /**
	     * @param countryName 
	     * @return
	     */

	    public ResponseEntity<?> getStocks() {
	        String url = apiUrl ;
	       
	        //creating a instance of resttemplate class provided by spring for making HTTP requests
	         RestTemplate restTemplate = new RestTemplate();
	        Stock result = new Stock();
	        result = restTemplate.getForObject(url,Stock.class);
	        System.out.println(result.getData());
	        return new ResponseEntity<>(result.getData(), HttpStatus.OK);
	    }

	

	    public ResponseEntity<?> getStocksByCountryName(String countryName) {
	        String url = Url + countryName;
	       
	        //creating a instance of resttemplate class provided by spring for making HTTP requests
	         RestTemplate restTemplate = new RestTemplate();
	        Stock result = new Stock();
	        result = restTemplate.getForObject(url,Stock.class);
	        System.out.println(result.getData());
	        return new ResponseEntity<>(result.getData(), HttpStatus.OK);
	    }
	}
