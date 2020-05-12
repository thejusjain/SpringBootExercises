package com.example.Learning.service;

import com.example.Learning.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    boolean loginValidate(String username, String password);

    boolean validateEmail(String email);


//    void userLogin(String username, String password);
}
