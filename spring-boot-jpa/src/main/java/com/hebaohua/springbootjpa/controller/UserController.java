package com.hebaohua.springbootjpa.controller;

import com.hebaohua.springbootjpa.entity.User;
import com.hebaohua.springbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("user/{id}")
    public User getUser(@PathVariable long id){
        User user = userRepository.getOne(id);

        return user;
    }

    @GetMapping("all")
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
