package com.abrar.store.mappers;

import com.abrar.store.dtos.UserDto;
import com.abrar.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);
}
