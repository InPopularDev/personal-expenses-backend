package com.codedgarcia.expenses.manager.transaction.controller;

import com.codedgarcia.expenses.manager.category.entity.Type;
import com.codedgarcia.expenses.manager.transaction.dto.CreateTransactionRequest;
import com.codedgarcia.expenses.manager.transaction.dto.TransactionResponse;
import com.codedgarcia.expenses.manager.transaction.service.TransactionService;
import com.codedgarcia.expenses.manager.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/all")
    public ResponseEntity<List<TransactionResponse>> getTransactions(
           @AuthenticationPrincipal User user) {

        List<TransactionResponse> trans = transactionService.getTransactions(user.getId());
        return ResponseEntity.ok(trans);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TransactionResponse>> getTransactionByType(
            @AuthenticationPrincipal User user,
            @RequestParam Type type) {

        List<TransactionResponse> response = transactionService.getTransactionsByUserIdAndType(
                user.getId(),
                type
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(
            @AuthenticationPrincipal User user,
            @RequestBody CreateTransactionRequest request){

        TransactionResponse response = transactionService.createTransaction(user.getId(),  request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
