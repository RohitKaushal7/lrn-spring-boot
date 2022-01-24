package com.dev.rest.controllers;

import java.util.List;
import java.util.Map;

import com.dev.rest.models.User;
import com.dev.rest.services.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/users")
    public User addUserPost(@RequestBody JsonNode user_json){
        User user = new User(null,user_json.get("name").textValue(),user_json.get("email").textValue(),user_json.get("password").textValue());
        System.out.println("adding user "+ user);
        return userService.createUser(user);
    }
    
}
