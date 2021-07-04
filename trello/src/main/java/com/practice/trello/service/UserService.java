package com.practice.trello.service;

import com.practice.trello.model.User;
import com.practice.trello.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepo userRepo;

    public void createUser(User user) {
        userRepo.save(user);
    }

    public void deleteUser(Integer userId){
        userRepo.deleteById(userId);
    }

    public User getUser(Integer userId){
        return userRepo.getByUserId(userId);
    }
}
