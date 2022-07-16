package com.example.angularspring.controller;

import com.example.angularspring.entity.User;
import com.example.angularspring.service.UserService;
import org.springframework.web.bind.annotation.*;

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
    Iterable<User> getAll(){
        return userService.findAll();
    }

    @PostMapping(path = "/registration")
    public @ResponseBody
    String postController(@RequestBody User body) {
        System.out.println(body);
        userService.save(body);
        return "saved";
    }

}
