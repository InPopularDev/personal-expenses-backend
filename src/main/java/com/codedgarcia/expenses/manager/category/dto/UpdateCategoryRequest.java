package com.codedgarcia.expenses.manager.category.dto;

import com.codedgarcia.expenses.manager.category.entity.Type;

public record UpdateCategoryRequest(
        String name,
        Type type
) {
}
