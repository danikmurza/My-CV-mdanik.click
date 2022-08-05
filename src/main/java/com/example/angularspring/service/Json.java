package com.example.angularspring.service;

import org.json.JSONObject;

public class Json {

    public  Object token(String token, int code){
        JSONObject obj = new JSONObject();
        obj.put("token", token);
        obj.put("code", code);
        return obj;
    }
}
