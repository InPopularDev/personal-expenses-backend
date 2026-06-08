package com.codedgarcia.expenses.manager.transaction.dto;

import com.codedgarcia.expenses.manager.category.entity.Type;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionResponse(
        Long id,

        BigDecimal amount,

        String description,

        LocalDate transactionDate,

        Long categoryId,

        String categoryName,

        Type categoryType
) {
}
