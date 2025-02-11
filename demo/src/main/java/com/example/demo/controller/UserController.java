package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String addUser(User user) throws Exception {
        try{
            this.userService.save(user);
            return "success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public User getUser(String userName) throws Exception {
        try{
            return this.userService.getUserByUsername(userName);
        }catch (Exception e){
            return null;
        }
    }
}
