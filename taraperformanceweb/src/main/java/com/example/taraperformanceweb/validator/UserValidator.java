package com.example.taraperformanceweb.validator;

import com.example.taraperformanceweb.model.User;
import com.example.taraperformanceweb.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class  UserValidator implements Validator {


    @Autowired
    private UserServiceImpl userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        // Checking if fields are blank
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty"); // username should not be null
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty"); // password should not be null
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");

        // Checking if Confirm Password works
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }

        // Checking for existing username
        if (userService.findByUsername(user.getUsername()) != null ) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        // email validation
        if (!userService.validateEmail(user.getEmail())){
            errors.rejectValue("email", "Format.userForm.email");
        }

        // Length of user name nad password validation
        if (user.getUsername().length() < 5 | user.getUsername().length() > 20) {
            errors.rejectValue("username", "Length.userForm.values");
        }
        if (user.getPassword().length() < 5 | user.getPassword().length() > 20) {
            errors.rejectValue("password", "Length.userForm.values");
        }

    }
}
