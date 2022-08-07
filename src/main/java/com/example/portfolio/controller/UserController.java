package com.example.portfolio.controller;

import com.example.portfolio.entity.User;
import com.example.portfolio.security.JwtUtils;
import com.example.portfolio.service.Json;
import com.example.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {


    private final UserService userService;
    private final JwtUtils jwtUtils;

    private final Json j;

    @Autowired
    public UserController(UserService userService, JwtUtils jwtUtils, Json j) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
        this.j = j;
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<User> getAll() {
        return userService.findAll();
    }

    @PostMapping(path = "/registration")
    public @ResponseBody ResponseEntity<Object> registration(@RequestBody User body) throws Exception {
        try {
            User users = userService.userFindByEmail(body.getEmail());
            if (users != null) {
                return new ResponseEntity<>(j.m("User already have"), HttpStatus.BAD_REQUEST);
            } else {
                User user = this.userService.registerNewUser(body);
                return new ResponseEntity<>(j.token(jwtUtils.generateJwtToken(user.getEmail(), user.getId())), HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(j.m(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/user")
    public @ResponseBody Object user(@RequestBody User body) {
        return userService.findById(body.getId());
    }

    @PostMapping(path = "/login")
    public @ResponseBody ResponseEntity<Object> login(@RequestBody User body) throws Exception {
        try {
            User user = userService.userFindByEmail(body.getEmail());
            if (user == null) {
                return new ResponseEntity<>(j.m("User not exist"), HttpStatus.NOT_FOUND);
            }
            if (!userService.checkPassword(body.getPassword(), user.getPassword())) {
                return new ResponseEntity<>(j.m("Password dont match"), HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(j.token(jwtUtils.generateJwtToken(user.getEmail(), user.getId())), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(j.m(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/update")
    public @ResponseBody Object update(@RequestBody User body) {
        return userService.updateUser(body);
    }

}
