package com.example.angularspring.repository;

import com.example.angularspring.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtRepository {

    public String generateToken(User user);

    public Object verify(String token);

}
