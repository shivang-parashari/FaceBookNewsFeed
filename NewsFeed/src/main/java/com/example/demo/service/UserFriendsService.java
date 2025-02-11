package com.example.demo.service;

import com.example.demo.model.UserFriend;
import com.example.demo.repository.UserFriendsRepository;

import java.util.List;

public class UserFriendsService {

    private UserFriendsRepository userFriendsRepository;


    public UserFriendsService(UserFriendsRepository userFriendsRepository) {
        this.userFriendsRepository = userFriendsRepository;
    }

    public void addUserFriend(String userId, String friendId) throws Exception {
        UserFriend userFriend = new UserFriend();
        userFriend.setUserName(userId);
        userFriend.setFriendName(friendId);

        try{
            this.userFriendsRepository.addUserFriend(userFriend);
        }catch (Exception e){
            throw new Exception("unable to add friend");
        }
    }

    public List<UserFriend> getUserFriends(String userId) throws Exception {
        try{
            return this.userFriendsRepository.getUserFriendsByUserName(userId);

        }catch (Exception e){
            throw new Exception("unable to get friends");
        }
    }
}
