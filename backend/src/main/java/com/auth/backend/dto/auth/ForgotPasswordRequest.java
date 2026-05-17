package com.auth.backend.dto.auth;

import com.auth.backend.constant.ResponseMessage;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class ForgotPasswordRequest {
    @Email(message = ResponseMessage.INVALID_EMAIL)
    private String email;
}
