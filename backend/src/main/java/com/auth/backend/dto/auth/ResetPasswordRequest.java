package com.auth.backend.dto.auth;

import com.auth.backend.constant.ResponseMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResetPasswordRequest {
    @NotBlank(message = ResponseMessage.TOKEN_REQUIRED)
    private String token;

    @NotBlank(message = ResponseMessage.PASSWORD_REQUIRED)
    @Size(min = 8,max = 50,message = ResponseMessage.PASSWORD_REQUIRED_LENGTH)
    private String password;

    @NotBlank(message = ResponseMessage.CONFIRM_PASSWORD_REQUIRED)
    @Size(min = 8,max = 50,message = ResponseMessage.CONFIRM_PASSWORD_REQUIRED_LENGTH)
    private String confirmPassword;
}
