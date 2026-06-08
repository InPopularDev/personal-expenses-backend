package com.codedgarcia.expenses.manager.auth.dto;



public record AuthResponse(
        String accessToken,
        String refreshToken
    ) {

}
