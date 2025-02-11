package com.example.demo.controller;

import com.example.demo.model.UserFriend;
import com.example.demo.service.UserFriendsService;

import java.util.List;

public class UserFriendsController {

    private UserFriendsService userFriendsService;

    public UserFriendsController(UserFriendsService userFriendsService) {
        this.userFriendsService = userFriendsService;
    }


    public String addUserFriend(String userId, String friendId) throws Exception {
        try{
            this.userFriendsService.addUserFriend(userId, friendId);
            return "success";
        }catch (Exception e){
            return "unable to add user friend";
        }
    }

    public List<UserFriend> userFriends(String userId) throws Exception {
        try{
            return this.userFriendsService.getUserFriends(userId);
        }catch (Exception e){
            return null;
        }
    }


}
