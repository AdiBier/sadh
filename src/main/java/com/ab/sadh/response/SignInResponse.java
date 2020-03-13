package com.ab.sadh.response;

import com.ab.sadh.model.Users;
import lombok.Data;

@Data
public class SignInResponse {

    private final Long userId;

    private final String email;

    private final String name;

    private final String surname;

    private final String role;

    private final String phone;

    public SignInResponse(Users user){
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.phone = user.getPhone();
        this.role = user.getRole();
    }
}
