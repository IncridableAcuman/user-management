package com.auth.backend.dto.auth;

public record AuthResponse(
        String accessToken
) {
    public static AuthResponse from(String accessToken){
        return new AuthResponse(accessToken);
    }
}
