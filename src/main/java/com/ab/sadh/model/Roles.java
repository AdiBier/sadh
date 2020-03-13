package com.ab.sadh.model;

import lombok.Getter;

@Getter
public enum Roles {
    CUSTOMER("CUSTOMER"),
    ADMIN("ADMIN");

    private String name;

    Roles(String name) {
        this.name = name;
    }
}
