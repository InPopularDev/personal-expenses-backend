package com.codedgarcia.expenses.manager.category.mapper;

import com.codedgarcia.expenses.manager.category.dto.CategoryResponse;
import com.codedgarcia.expenses.manager.category.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryResponse toResponse(
            Category category) {

        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getType()
        );
    }
}
