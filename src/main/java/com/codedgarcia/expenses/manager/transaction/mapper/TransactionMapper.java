package com.codedgarcia.expenses.manager.transaction.mapper;

import com.codedgarcia.expenses.manager.transaction.dto.TransactionResponse;
import com.codedgarcia.expenses.manager.transaction.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionResponse toResponse(
            Transaction transaction) {
        return new TransactionResponse(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getTransactionDate(),
                transaction.getCategory().getId(),
                transaction.getCategory().getName(),
                transaction.getCategory().getType()
        );
    }
}
