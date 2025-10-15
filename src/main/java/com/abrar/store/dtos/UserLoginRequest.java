package com.abrar.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserLoginRequest {
    @NotNull(message = "Email cannot be null")
    @Email(message = "Must be a valid email")
    private String email;

    @NotNull(message = "Password cannot be null")
    private String password;
}
