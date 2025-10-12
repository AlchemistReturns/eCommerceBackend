package com.abrar.store.mappers.helpers;

import com.abrar.store.entities.Category;
import com.abrar.store.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryMapperHelper {
    private CategoryRepository categoryRepository;

    public Category map(Byte categoryId) {
        if (categoryId == null) return null;
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID: " + categoryId));
    }
}
