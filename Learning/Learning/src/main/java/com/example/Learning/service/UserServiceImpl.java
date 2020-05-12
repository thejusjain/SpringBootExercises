package com.example.Learning.service;

import com.example.Learning.model.User;
import com.example.Learning.repository.UserRepository;
import com.example.Learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean loginValidate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) return false;

        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();

    }


//    @Override
//    public void userLogin(String username, String password) {
//        UserDetails userDetails =
//
//    }

}
