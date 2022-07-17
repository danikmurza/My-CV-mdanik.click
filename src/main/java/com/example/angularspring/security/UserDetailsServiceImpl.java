package com.example.angularspring.security;

import com.example.angularspring.entity.User;
import com.example.angularspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//
//    @Autowired
//    UserRepository userRepository;
//
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email);
//        return UserDetails.build(user);
//    }
//}
