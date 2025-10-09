package com.abrar.store.repositories;

import com.abrar.store.dtos.UserDto;
import com.abrar.store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
