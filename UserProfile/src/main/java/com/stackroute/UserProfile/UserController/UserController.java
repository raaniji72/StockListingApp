package com.stackroute.UserProfile.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.UserProfile.UserEntity.User;
import com.stackroute.UserProfile.UserService.UserService;


import java.util.List;
//import io.swagger.v3.oas.annotations.Hidden;

@CrossOrigin()
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService; 

    
 
    @GetMapping("/getUser")
    public ResponseEntity<?> getAllUsers() {
        List<User> user = userService.getAllUser();
       

        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No favorites found for user with ID: " );
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
    } 
     
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
    	return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
    }
}