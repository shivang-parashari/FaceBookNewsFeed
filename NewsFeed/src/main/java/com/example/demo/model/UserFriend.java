package com.example.demo.model;


public class UserFriend extends Base {

    private String userName;

    private String friendName;

    public String getUserName() {
        return this.userName;
    }

    public String getFriendName() {
        return this.friendName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
}
