package com.ab.sadh.service;

import com.ab.sadh.model.LoginCredentials;
import com.ab.sadh.model.Users;

import java.util.Optional;

public interface LoginService {

    Optional<Users> login(LoginCredentials loginCredentials);
}
