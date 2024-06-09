package com.stackroute.WishlistService.ResponseHandler;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.stackroute.WishlistService.entity.WishList;

public class ResponseHandler {

	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseTrack) {
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("message", message);
		responseMap.put("status", status.value());
		responseMap.put("track", responseTrack);
 
		return new ResponseEntity<>(responseMap, status);
	}


}
