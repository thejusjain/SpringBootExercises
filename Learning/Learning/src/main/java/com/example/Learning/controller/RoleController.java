package com.example.Learning.controller;


import com.example.Learning.repository.RoleRepository;
import com.example.Learning.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

//    List<Integer> roleIds = Arrays.asList(1,2,3);
//
//    @GetMapping("/welcome")
//    public List<String> roleNames(){
//        return roleRepository.findRoleNames(roleIds);
////        return userRoleRepository.findRoleId(1);
//    }
}
