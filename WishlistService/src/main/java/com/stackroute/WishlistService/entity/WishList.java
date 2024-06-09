package com.stackroute.WishlistService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;
 

@Entity
public class WishList {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long favId;
	private long userId;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String symbol;
	private String name;
	private String currency;
	private String exchange;
	private String country;
	private String type;
	
	public long getFavId() {
		return favId;
	}
	public void setFavId(long favId) {
		this.favId = favId;
	}
 
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public WishList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WishList(long favId,String username, long userId, String symbol, String name, String currency,
			String exchange,  String country, String type) {
		super();
		this.favId = favId;
		this.userId = userId;
		this.username=username;
		this.symbol = symbol;
		this.name = name;
		this.currency = currency;
		this.exchange = exchange;
		
		this.country = country;
		this.type = type;
	}
	
}