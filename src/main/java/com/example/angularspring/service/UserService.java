package com.example.angularspring.service;

import com.example.angularspring.entity.Role;
import com.example.angularspring.entity.User;
import com.example.angularspring.repository.RoleRepository;
import com.example.angularspring.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository,  RoleRepository roleRepository) {
        this.userRepository = userRepository;

        this.roleRepository = roleRepository;
    }


    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        User users = userRepository.save(user);
        return users;
    }

    public User userFindByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Object updateUser(User body) {
        Object email = userRepository.findByEmail(body.getEmail());
        System.out.println(email);
        return "Updated";
    }

    public Object registerNewUser(User dto) throws Exception {
        User users = userFindByEmail(dto.getEmail());
        if(users != null){
            return "have";
        }
        String passwd = encoder.encode(dto.getPassword());
//        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
//        System.out.print(Collections.singletonList(adminRole));
        user.setPassword(passwd);
        user.setUrlAvatar(dto.getUrlAvatar());
//        user.setRoles(Arrays.asList(adminRole));
        User r = userRepository.save(user);
        return r;
    }

    public Object login(User dto){
        User users = userFindByEmail(dto.getEmail());
        if(users == null){
            return "Dont Have";
        }
        boolean match = encoder.matches(dto.getPassword(), users.getPassword());
        System.out.println(match);
        if(!match){
            return "Password No MATCh";
        }
        return users;
    }
}
