package com.abrar.store.dtos;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private Long id;
    private String name;
    private String email;
    private String password;
}
