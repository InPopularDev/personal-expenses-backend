package com.codedgarcia.expenses.manager.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateTransactionRequest(
        Long categoryId,

        BigDecimal amount,

        String description,

        LocalDate transactionDate
) {

}
