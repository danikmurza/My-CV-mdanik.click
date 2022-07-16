package com.example.angularspring.service;

import com.example.angularspring.entity.User;
import com.example.angularspring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Optional<User> findBiId(Long id){
        return userRepository.findById(id);
    }

    public void save(User user){
        userRepository.save(user);
    }

}
