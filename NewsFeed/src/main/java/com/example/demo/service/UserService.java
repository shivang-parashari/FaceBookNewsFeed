package com.example.demo.service;

import com.example.demo.exception.UserException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) throws UserNotFoundException {
        try{
            return this.userRepository.getUserByUsername(username);
        }catch (UserNotFoundException e){
            return null;
        }

    }

    public void save(User user) throws UserException {
        try{
            this.userRepository.addUser(user);
        }catch (UserException e){
            throw new UserException(e.getMessage());
        }
    }

}
