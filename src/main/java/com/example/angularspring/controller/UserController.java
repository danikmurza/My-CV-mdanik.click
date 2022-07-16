package com.example.angularspring.controller;

import com.example.angularspring.entity.User;
import com.example.angularspring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path ="/")
    public @ResponseBody
    Iterable<User> getAll(){
        return userService.findAll();
    }

    @PostMapping(path = "/registration")
    public @ResponseBody
    Object registration(@RequestBody User body) {
       return userService.save(body);
    }

    @PostMapping(path = "/user")
    public @ResponseBody
    Object user(@RequestBody User body) {
        return userService.findById(body.getId());
    }

    @PostMapping(path = "/login")
    public @ResponseBody
    Object login(@RequestBody User body) {
       return userService.userFindByEmail(body.getEmail());
    }

    @PostMapping(path = "/update")
    public @ResponseBody
    Object update(@RequestBody User body) {
        return userService.updateUser(body);
    }

}
