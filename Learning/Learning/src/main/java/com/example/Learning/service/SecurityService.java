package com.example.Learning.service;

import com.example.Learning.model.User;
import org.springframework.stereotype.Service;

public interface SecurityService {
//    String findLoggedInUsername();

    void login(String username, String password);
}
