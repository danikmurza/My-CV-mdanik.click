package com.example.angularspring.controller;

import com.example.angularspring.entity.User;
import com.example.angularspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path ="/")
    public String welcome(){
        return "Hello word";
    }

    @PostMapping(path ="/login")
    public String login(){
        return "Login";
    }


    @GetMapping(path ="/users")
    public @ResponseBody
    List<User> getAll(){
        return userService.findAll();
    }
}
