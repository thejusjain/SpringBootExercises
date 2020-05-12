package com.example.taraperformanceweb.service;

import com.example.taraperformanceweb.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    boolean loginValidate(String username, String password);

    boolean validateEmail(String email);


//    void userLogin(String username, String password);
}
