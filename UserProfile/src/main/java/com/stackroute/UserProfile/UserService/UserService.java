package com.stackroute.UserProfile.UserService;

import java.util.List;

import com.stackroute.UserProfile.UserEntity.User;

public interface UserService {

	//create

   List<User> getAllUser();

    User saveUser(User user);

    User updateUser(long userId, User user);

    User getUserById(long userId);
	
}
