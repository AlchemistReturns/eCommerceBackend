package com.abrar.store.controllers;

import com.abrar.store.dtos.RegisterUserRequest;
import com.abrar.store.dtos.UserDto;
import com.abrar.store.entities.User;
import com.abrar.store.mappers.UserMapper;
import com.abrar.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userToUserDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        User user =  userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.userToUserDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @RequestBody RegisterUserRequest registerUserRequest,
            UriComponentsBuilder uriComponentsBuilder) {
        User user = userMapper.toUser(registerUserRequest);
        user = userRepository.save(user);
        UserDto userDto = userMapper.userToUserDto(user);
        URI location = uriComponentsBuilder
                .path("/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(userDto);
    }


}
