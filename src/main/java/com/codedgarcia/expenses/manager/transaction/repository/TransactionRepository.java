package com.codedgarcia.expenses.manager.transaction.repository;

import com.codedgarcia.expenses.manager.category.entity.Type;
import com.codedgarcia.expenses.manager.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByIdAndUserId(
            Long transactionId,
            Long userId);

    List<Transaction> findByUserIdAndCategoryId(
            Long userId,
            Long categoryId);

    List<Transaction> findByUserIdAndTransactionDateBetween(
            Long userId,
            LocalDate start,
            LocalDate end);

    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByUserIdAndCategoryType(
            Long userId,
            Type type);
}
