package com.example.angularspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class userController {

    public userController() {
    }

    @GetMapping(path ="/")
    public String welcome(){
        return "Hello word";
    }
}
