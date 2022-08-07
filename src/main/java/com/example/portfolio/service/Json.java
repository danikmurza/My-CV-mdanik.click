package com.example.portfolio.service;

import com.example.portfolio.repository.ObjectRepository;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class Json implements ObjectRepository {



    @Override
    public Object token(String token) {
        JSONObject obj = new JSONObject();
        obj.put("token", token);
        return obj.toString();
    }


    @Override
    public Object Error(String message) {
        return null;
    }

    public Object m(String message) {
        JSONObject obj = new JSONObject();
        obj.put("message", message);
        return obj.toString();
    }
}
