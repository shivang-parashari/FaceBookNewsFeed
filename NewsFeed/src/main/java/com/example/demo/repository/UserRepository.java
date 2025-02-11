package com.example.demo.repository;


import com.example.demo.model.User;
import lombok.Data;

import java.util.ArrayList;

@Data
public class UserRepository {

    ArrayList<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }


    public User getUserByUsername(String username) {
        for (User user : users) {
            if(username.equals(user.getUserName())){
                return user;
            }
        }
        return null;
    }


    // Delete



}
