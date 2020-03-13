package com.ab.sadh.service.impl;

import com.ab.sadh.handler.UserSignUpDTO;
import com.ab.sadh.model.Users;
import com.ab.sadh.repository.UsersRepository;
import com.ab.sadh.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Lazy
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<Users> loadUserByEmail(String email) {
        Users user = usersRepository.findByEmail(email);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<Users> loadUserByName(String name) {
        Users user = usersRepository.findByName(name);
        return Optional.ofNullable(user);
    }

    @Override
    public Users save(UserSignUpDTO signUpDTO) {
        Users user = new Users(signUpDTO.getEmail(), signUpDTO.getName(), signUpDTO.getSurname(), passwordEncoder.encode(signUpDTO.getPassword()), signUpDTO.getPhone(), "CUSTOMER");
        return usersRepository.save(user);
    }

    @Override
    public Users update(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public void delete(Users user) {
        usersRepository.delete(user);
    }
}
