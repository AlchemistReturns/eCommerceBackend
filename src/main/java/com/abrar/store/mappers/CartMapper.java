package com.abrar.store.mappers;

import com.abrar.store.dtos.CartDto;
import com.abrar.store.entities.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto cartToCartDto(Cart cart);
}
