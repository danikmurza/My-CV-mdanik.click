package com.example.angularspring.service;

import com.example.angularspring.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnObject implements ObjectRepository {

    private final UserService userService;

    public ReturnObject(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object token(Long userId) {
        return userService.findById(userId);
    }

    @Override
    public Object token(int userId) {
        return null;
    }

    @Override
    public Object message(String message, int code) {
        return null;
    }

    @Override
    public Object Error(String message, int code) {
        return null;
    }
}
