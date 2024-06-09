package com.stackroute.Authentication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.Authentication.entity.UserInfo;
import com.stackroute.Authentication.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo repo;
	
	@Override
    public UserInfo fetchUserDetails(UserInfo user) {
        Optional<UserInfo> userinfo=repo.findById(user.getUsername());
        if(userinfo.isEmpty()) {
            return	repo.save(user);
        } else {
            return null;
        }
    }
 
    @Override
    public boolean loginUser(String username, String password) {
        Optional<UserInfo> user= repo.findByUsernameAndPassword(username, password);
        if(user.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
    }
