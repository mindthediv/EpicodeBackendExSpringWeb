package com.pack.appfiles.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.appfiles.security.models.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}