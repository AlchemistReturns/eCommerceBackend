package com.abrar.store.services;

import com.abrar.store.entities.User;
import com.abrar.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        Long id = (Long) authentication.getPrincipal();

        return userRepository.findById(id).orElse(null);
    }
}
