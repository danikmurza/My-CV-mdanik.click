package com.example.angularspring.controller;

import com.example.angularspring.entity.User;
import com.example.angularspring.security.JwtUtils;
import com.example.angularspring.service.Json;
import com.example.angularspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {


    private final UserService userService;
    private final JwtUtils jwtUtils;

    private final Json jj;

    @Autowired
    public UserController(UserService userService, JwtUtils jwtUtils, Json jj) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
        this.jj = jj;
    }

    @GetMapping(path ="/")
    public @ResponseBody
    Iterable<User> getAll(){
        return userService.findAll();
    }

    @PostMapping(path = "/registration")
    public @ResponseBody
    ResponseEntity<Object> registration(@RequestBody User body) throws Exception {
        User users = userService.userFindByEmail(body.getEmail());
        if(users != null){
            return new ResponseEntity<>(jj.message("Already have"), HttpStatus.BAD_REQUEST);
        }

       return new ResponseEntity<>( userService.registerNewUser(body), HttpStatus.CREATED);
    }

    @PostMapping(path = "/user")
    public @ResponseBody
    Object user(@RequestBody User body) {
        return userService.findById(body.getId());
    }

    @PostMapping(path = "/login")
    public @ResponseBody
    ResponseEntity<Object> login(@RequestBody User body) throws Exception {
        try {
            User user = userService.userFindByEmail(body.getEmail());
            if(user==null){
               return new ResponseEntity<>("User not exist", HttpStatus.NOT_FOUND);
            }if(!userService.checkPassword(body.getPassword(), user.getPassword())){
                return new ResponseEntity<Object>("Password dont match", HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity<>(jj.token(jwtUtils.generateJwtToken(user.getEmail(), user.getId())), HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/update")
    public @ResponseBody
    Object update(@RequestBody User body) {
        return userService.updateUser(body);
    }

}
