package com.example.angularspring.service;

import com.example.angularspring.entity.User;
import com.example.angularspring.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User save(User user){
       User users = userRepository.save(user);
       return users;
    }

    public Object userFindByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Object updateUser(User body) {
        Object email = userRepository.findByEmail(body.getEmail());
        System.out.println(email);
        return "Updated";
    }
}
