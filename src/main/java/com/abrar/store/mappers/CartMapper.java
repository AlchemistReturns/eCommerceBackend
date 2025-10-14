package com.abrar.store.mappers;

import com.abrar.store.dtos.CartDto;
import com.abrar.store.dtos.CartItemDto;
import com.abrar.store.entities.Cart;
import com.abrar.store.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto cartToCartDto(Cart cart);
    @Mapping(target = "totalPrice", expression = "java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);
}
