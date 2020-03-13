package com.ab.sadh.service;

import com.ab.sadh.handler.UserSignUpDTO;
import com.ab.sadh.model.Users;

import java.util.Optional;

public interface UserService {

    Optional loadUserByEmail(String email);

    Optional loadUserByName(String name);

    Users save(UserSignUpDTO signUpDTO);

    Users update(Users user);

    void delete(Users user);
}
