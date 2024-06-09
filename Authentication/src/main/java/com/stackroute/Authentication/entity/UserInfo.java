package com.stackroute.Authentication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class UserInfo {

	
	
	@Id
	String username;
	String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UserInfo() {
	}
	@Override
	public String toString() {
		return "UserInfo{" + "username='" +username + '\''+",password='" + password + '\''+'}';
 	}
}
