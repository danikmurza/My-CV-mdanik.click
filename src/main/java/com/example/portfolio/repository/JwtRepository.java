package com.example.portfolio.repository;

import com.example.portfolio.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtRepository {

    public String generateToken(User user);

    public Object verify(String token);

}
