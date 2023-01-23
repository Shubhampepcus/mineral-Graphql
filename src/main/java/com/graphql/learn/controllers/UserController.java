package com.graphql.learn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.graphql.learn.entities.User;
import com.graphql.learn.services.UserService;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
    
    @QueryMapping("getUser")
    public User getUserById(@Argument int userId){
        return userService.getUserById(userId);
    }
    
    @QueryMapping("allUsers")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
}
