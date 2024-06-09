package com.stackroute.Authentication.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stackroute.Authentication.entity.UserInfo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



	
public class JwtGenerator {
    public Map<String, String> generateToken(UserInfo user) {
       
    	//creating HashMap to store the user data 
        Map<String, Object> userdata = new HashMap<>();
 
        userdata.put("username", user.getUsername());
        userdata.put("password", user.getPassword());
 
        //generating the JWT token by builder
        String jwtToken = "";
 
        jwtToken = Jwts.builder().setClaims(userdata)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret").compact();
     
        // Adding the JWTToken and a message in the JWTtokenMap 
        Map<String, String> jwtTokenMap = new HashMap<>();
        jwtTokenMap.put("token", jwtToken);
        jwtTokenMap.put("message", "Login Successful");
        return jwtTokenMap;
 
    }
}