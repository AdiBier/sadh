package com.ab.sadh.repository;

import com.ab.sadh.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository <Users, Long> {

    Users findByEmail(String email);

    Users findByName(String name);

    boolean existsByUserId(Long id);

    Users findByUserId(Long id);

    Optional<Users> findOptionalByUserId(Long id);

    Users findByRole(String role);
}
