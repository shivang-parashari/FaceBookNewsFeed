package com.example.demo.repository;


import com.example.demo.model.UserFriend;
import lombok.Data;

import java.util.ArrayList;

@Data
public class UserFriendsRepository {

    ArrayList<UserFriend> userFriends = new ArrayList<>();

    public void addUserFriend(UserFriend userFriend) {
        userFriends.add(userFriend);
    }

    public ArrayList<UserFriend> getUserFriendsByUserName( String userName ) {
        ArrayList<UserFriend> userFriendList = new ArrayList<>();
        for(UserFriend userFriend : userFriends) {
            if(userFriend.getUserName().equals(userName)) {
                userFriendList.add(userFriend);
            }
        }

        return userFriendList;
    }


}
