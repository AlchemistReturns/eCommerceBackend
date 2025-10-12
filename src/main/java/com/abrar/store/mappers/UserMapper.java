package com.abrar.store.mappers;

import com.abrar.store.dtos.RegisterUserRequest;
import com.abrar.store.dtos.UpdateUserRequest;
import com.abrar.store.dtos.UserDto;
import com.abrar.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);
    User toUser(RegisterUserRequest registerUserRequest);
    public void updateUser(UpdateUserRequest updateUserRequest, @MappingTarget User user);
}
