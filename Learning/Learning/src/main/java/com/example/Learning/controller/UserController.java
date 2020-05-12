package com.example.Learning.controller;

import com.example.Learning.service.SecurityServiceImpl;
import com.example.Learning.service.UserServiceImpl;
import com.example.Learning.validator.UserValidator;
import com.example.Learning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private SecurityServiceImpl securityService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }


    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult){
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        return "redirect:/welcome";
    }

    @GetMapping({"/", "/login"})
    public String loginPage() {

        return "hello";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") User loginUser, BindingResult bindingResult, Model model) {
        boolean validLogin = userService.loginValidate(loginUser.getUsername(), loginUser.getPassword());
        if (validLogin) {
            securityService.login(loginUser.getUsername(), loginUser.getPassword());
            model.addAttribute("username", loginUser.getUsername());
            return "welcome";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";

    }

}