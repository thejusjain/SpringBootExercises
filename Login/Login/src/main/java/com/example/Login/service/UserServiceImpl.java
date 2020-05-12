package com.example.Login.service;

import com.example.Login.model.User;
import com.example.Login.repository.RoleRepository;
import com.example.Login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        System.out.println("Encrypting the password");
        userRepository.save(user); // Adding to the database
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
