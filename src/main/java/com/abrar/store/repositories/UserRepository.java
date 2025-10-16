package com.abrar.store.repositories;

import com.abrar.store.dtos.UserDto;
import com.abrar.store.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(@NotNull(message = "Email cannot be null") @Email(message = "Must be a valid email") String email);
}
