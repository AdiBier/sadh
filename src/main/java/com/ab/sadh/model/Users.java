package com.ab.sadh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long userId;

    @Column(name = "Email", nullable = false, unique = true, length = 64)
    private String email;

    @Column(name = "Name", length = 32)
    private String name;

    @Column(name = "Surname", length = 32)
    private String surname;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Phone", length = 20)
    private String phone;

    @NotEmpty
    @Column(name = "Role")
    private String role;

    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Product> products;

    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Mission> missions;

    public Users(String email, String name, String surname, String password, String phone, String role){
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public Users(Users user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.role = user.getRole();
    }
}
