package com.practice.trello.controller;

import com.practice.trello.model.User;
import com.practice.trello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        userService.createUser(user);
        return user;
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam Integer userId){
        return userService.getUser(userId);
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam Integer userId){
        userService.deleteUser(userId);
        return String.format("Deleted User %d", userId);
    }

}
