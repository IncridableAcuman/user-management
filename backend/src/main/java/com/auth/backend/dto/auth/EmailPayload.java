package com.auth.backend.dto.auth;

public record EmailPayload(
        String to,
        String subject,
        String text
) {
}
