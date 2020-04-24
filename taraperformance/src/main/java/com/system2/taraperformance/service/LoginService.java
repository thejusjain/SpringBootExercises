package com.system2.taraperformance.service;


import com.system2.taraperformance.model.Users;
import com.system2.taraperformance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;


    public int loginUser(Users users) {
        Users dbUser;
        try {
            dbUser = userRepository.findById(users.getUsername()).get();
        } catch (NoSuchElementException e) {
            return -1;
        }
        if (dbUser.getPassword().equals(users.getPassword())) {
            return 1;
        } else {
            return 0;
        }
    }

//    public List<String> getUserIds(Users users) {
//        String userType = users.getUserType();
////        if (userType == "manager") {
////            List<String> userIds = userRepository.
////        }
//
//    }
}
