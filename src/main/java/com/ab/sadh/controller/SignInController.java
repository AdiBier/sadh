package com.ab.sadh.controller;

import com.ab.sadh.exception.BadNameOrPasswordException;
import com.ab.sadh.exception.UserNotFoundException;
import com.ab.sadh.exception.UserNotRegisteredException;
import com.ab.sadh.model.LoginCredentials;
import com.ab.sadh.model.Users;
import com.ab.sadh.response.SignInResponse;
import com.ab.sadh.service.UserService;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class SignInController {

    private final String WRONG_NAME_PASSWORD = "Invalid name or password";

    private final String WRONG_INSTANCE = "UserDetails wrong";

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private final UserService userService;

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public SignInResponse signIn(@RequestBody LoginCredentials loginCredentials, HttpServletResponse response)
            throws UserNotFoundException, BadNameOrPasswordException, UserNotRegisteredException {

        String email = loginCredentials.getEmail();
        String password = loginCredentials.getPassword();
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadNameOrPasswordException(WRONG_NAME_PASSWORD);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        ArrayList<String> userRoles = (ArrayList<String>) userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        response.setHeader("Authorization", "");

        if (userDetails instanceof UserDetails) {
            Optional<Users> usersInfo = userService.loadUserByEmail(userDetails.getUsername());
            if (usersInfo.isPresent()) {
                return new SignInResponse(usersInfo.get());
            } else {
                throw new UserNotFoundException("User with email " + userDetails.getUsername() + " not found");
            }
        } else {
            throw new UserNotRegisteredException(WRONG_INSTANCE);
        }
    }
}
