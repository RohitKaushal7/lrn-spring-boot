package com.dev.rest.controllers;

import java.util.List;

import com.dev.rest.models.User;
import com.dev.rest.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/adduser")
    public User addUser(User user){
        return userService.createUser(user);
    }
    
}
