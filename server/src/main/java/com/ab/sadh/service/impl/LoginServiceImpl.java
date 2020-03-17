package com.ab.sadh.service.impl;

import com.ab.sadh.model.LoginCredentials;
import com.ab.sadh.model.Users;
import com.ab.sadh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserServiceImpl userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public LoginServiceImpl(UserServiceImpl userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<Users> login(LoginCredentials loginCredentials) {
        return userService.loadUserByEmail(loginCredentials.getEmail())
                .filter(user -> passwordEncoder.matches(loginCredentials.getPassword(), user.getPassword()))
                .map(user -> new Users(user));
    }
}
