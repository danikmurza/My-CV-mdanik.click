package com.example.angularspring.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository {

    Object token(String token);

    Object message(String message, int code);

    Object Error(String message, int code);

}
