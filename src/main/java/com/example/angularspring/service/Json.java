package com.example.angularspring.service;

import com.example.angularspring.repository.ObjectRepository;
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
    public Object message(String message, int code) {
        return null;
    }

    @Override
    public Object Error(String message, int code) {
        return null;
    }

    public Object message(String already_have) {
        JSONObject obj = new JSONObject();
        obj.put("message", already_have);
        return obj.toString();
    }
}
