package com.example.Login.service;

import com.example.Login.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
