package com.codedgarcia.expenses.manager.transaction.service;

import com.codedgarcia.expenses.manager.category.entity.Type;
import com.codedgarcia.expenses.manager.transaction.dto.CreateTransactionRequest;
import com.codedgarcia.expenses.manager.transaction.dto.TransactionResponse;
import com.codedgarcia.expenses.manager.transaction.dto.UpdateTransactionRequest;

import java.util.List;

public interface TransactionService {

    TransactionResponse createTransaction(
            Long userId,
            CreateTransactionRequest request);

    TransactionResponse getTransaction(
            Long userId,
            Long transactionId);

    List<TransactionResponse> getTransactions(
            Long userId);

    List<TransactionResponse> getTransactionsByUserIdAndType(
            Long userId,
            Type type
    );

    TransactionResponse updateTransaction(
            Long userId,
            Long transactionId,
            UpdateTransactionRequest request);

    void deleteTransaction(
            Long userId,
            Long transactionId);

}
