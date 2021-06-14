package com.ashish.game.service;


import com.ashish.game.domain.User;

import com.ashish.game.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public User create(User user) {
        User origUser = userRepository.findByUserName(user.getUserName());
        if(origUser ==null)
        return userRepository.save(user);
        else {
            return origUser;
        }

    }

    public User getUserById(int id)
    {
        return userRepository.findById(id).get();
    }

    public List<User> findAll() {
       return userRepository.findAll();
    }

    public User getUserByUserName(String userName)
    {
        return userRepository.findByUserName(userName);
    }

}
