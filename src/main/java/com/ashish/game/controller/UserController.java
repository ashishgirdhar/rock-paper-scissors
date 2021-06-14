package com.ashish.game.controller;

import com.ashish.game.domain.User;
import com.ashish.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/id/{id}")
    public User findById(@PathVariable final Integer id){
        return userService.getUserById(id);
    }

    @GetMapping(value="/name/{name}")
    public User findByName(@PathVariable final String name){
        return userService.getUserByUserName(name);
    }

    @GetMapping(value = "/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.create(user);
    }


}
