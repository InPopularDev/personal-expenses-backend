package com.codedgarcia.expenses.manager.category.dto;

import com.codedgarcia.expenses.manager.category.entity.Type;

public record CreateCategoryRequest(
        String name,
        Type type
) {
}
