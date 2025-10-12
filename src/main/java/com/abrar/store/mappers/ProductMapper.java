package com.abrar.store.mappers;

import com.abrar.store.dtos.ProductDto;
import com.abrar.store.entities.Product;
import com.abrar.store.mappers.helpers.CategoryMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapperHelper.class})
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto productToProductDto(Product product);
    @Mapping(source = "categoryId", target="category")
    Product toProduct(ProductDto productDto);
}
