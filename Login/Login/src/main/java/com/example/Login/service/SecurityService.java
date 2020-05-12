package com.example.Login.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
