package com.abrar.store.mappers;

import com.abrar.store.dtos.ProductDto;
import com.abrar.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto productToProductDto(Product product);
}
