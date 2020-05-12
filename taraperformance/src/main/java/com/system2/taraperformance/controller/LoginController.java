package com.system2.taraperformance.controller;

import com.system2.taraperformance.model.Users;
import com.system2.taraperformance.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public int loginUser(@RequestBody Users users) {
        System.out.println(users.getUsername());
        System.out.println(users.getPassword());
        int status = loginService.loginUser(users);
        return status;
//        if (status == 1) {
//            List<String> userIds = loginService.getUserIds(users);
//        }
    }
}
