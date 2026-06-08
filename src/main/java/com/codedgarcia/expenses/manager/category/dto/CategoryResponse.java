package com.codedgarcia.expenses.manager.category.dto;

import com.codedgarcia.expenses.manager.category.entity.Type;

public record CategoryResponse(
        Long id,
        String name,
        Type type
) {
}
