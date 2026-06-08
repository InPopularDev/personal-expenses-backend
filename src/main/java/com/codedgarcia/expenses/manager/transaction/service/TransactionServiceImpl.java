package com.codedgarcia.expenses.manager.transaction.service;

import com.codedgarcia.expenses.manager.category.entity.Category;
import com.codedgarcia.expenses.manager.category.entity.Type;
import com.codedgarcia.expenses.manager.category.repository.CategoryRepository;
import com.codedgarcia.expenses.manager.transaction.dto.CreateTransactionRequest;
import com.codedgarcia.expenses.manager.transaction.dto.TransactionResponse;
import com.codedgarcia.expenses.manager.transaction.dto.UpdateTransactionRequest;
import com.codedgarcia.expenses.manager.transaction.entity.Transaction;
import com.codedgarcia.expenses.manager.transaction.mapper.TransactionMapper;
import com.codedgarcia.expenses.manager.transaction.repository.TransactionRepository;
import com.codedgarcia.expenses.manager.user.entity.User;
import com.codedgarcia.expenses.manager.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final TransactionMapper transactionMapper;


    @Override
    public TransactionResponse createTransaction(
            Long userId, CreateTransactionRequest request) {
        User user = userRepository.findById(userId).orElseThrow();

        Category category = categoryRepository
                .findByIdAndUserId(request.categoryId(),userId)
                .orElseThrow();

        Transaction transaction = Transaction.builder()
                .user(user)
                .category(category)
                .amount(request.amount())
                .description(request.description())
                .transactionDate(request.transactionDate())
                .createdAt(LocalDateTime.now())
                .build();

        return transactionMapper
                .toResponse(
                        transactionRepository.save(transaction));
    }

    @Override
    public TransactionResponse getTransaction(Long userId, Long transactionId) {
        return transactionRepository
                .findByIdAndUserId(userId,transactionId)
                .map(transactionMapper::toResponse)
                .orElseThrow();
    }

    @Override
    public List<TransactionResponse> getTransactions(Long userId) {

        return transactionRepository
                .findByUserId(userId)
                .stream()
                .map(transactionMapper::toResponse)
                .toList();
    }

    @Override
    public List<TransactionResponse> getTransactionsByUserIdAndType(Long userId, Type type) {
        return transactionRepository
                .findByUserIdAndCategoryType(userId, type)
                .stream()
                .map(transactionMapper::toResponse)
                .toList();
    }

    @Override
    public TransactionResponse updateTransaction(
            Long userId,
            Long transactionId,
            UpdateTransactionRequest request) {

        Transaction transaction = transactionRepository
                .findByIdAndUserId(transactionId,userId)
                .orElseThrow();

        Category category = categoryRepository
                .findByIdAndUserId(
                        userId,
                        request.categoryId()
                )
                .orElseThrow();

        transaction.setCategory(category);
        transaction.setAmount(request.amount());
        transaction.setDescription(request.description());
        transaction.setTransactionDate(
                request.transactionDate()
        );


        return transactionMapper
                .toResponse(transactionRepository
                        .save(transaction));
    }

    @Override
    public void deleteTransaction(Long userId, Long transactionId) {
        Transaction transaction = transactionRepository
                .findByIdAndUserId(transactionId,userId)
                .orElseThrow();
        transactionRepository.delete(transaction);
    }
}
