package com.abrar.store.mappers;

import com.abrar.store.dtos.OrderDto;
import com.abrar.store.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
}
