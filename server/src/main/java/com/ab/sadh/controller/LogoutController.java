package com.ab.sadh.controller;

import com.ab.sadh.exception.UnauthenticatedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/logout")
public class LogoutController {

    private final String UNAUTHORIZED_MESSAGE = "User is unauthenticated";

    public RedirectView logout(Authentication auth, HttpServletResponse response) throws UnauthenticatedException {
        if(auth != null){
            response.setHeader("Authorization",  "");
            return new RedirectView("/");
        }
        throw new UnauthenticatedException(UNAUTHORIZED_MESSAGE);
    }
}
