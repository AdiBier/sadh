package com.ab.sadh.handler;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@FieldMatch.List({
        @FieldMatch(first = "password", second = "repeatPassword", message = "The password fields must match")
})
public class UserSignUpDTO {

    private String email;

    private String name;

    private String surname;

    @NotEmpty
    private String password;

    @NotEmpty
    private String repeatPassword;

    private String phone;
}
