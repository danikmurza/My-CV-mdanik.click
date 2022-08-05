package com.example.angularspring.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository {

    Object token(String token);

    Object m(String message);

    Object Error(String message);

}
