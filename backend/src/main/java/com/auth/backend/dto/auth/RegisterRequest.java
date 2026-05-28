package com.auth.backend.dto.auth;

import com.auth.backend.constant.ResponseMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = ResponseMessage.USER_NAME_REQUIRED)
    @Size(min = 3,max = 50,message = ResponseMessage.USER_NAME_REQUIRED_LENGTH)
    private String username;
    @Email(message = ResponseMessage.INVALID_EMAIL)
    private String email;
    @NotBlank(message = ResponseMessage.PASSWORD_REQUIRED)
    @Size(min = 8,max = 50,message = ResponseMessage.PASSWORD_REQUIRED_LENGTH)
    private String password;
}
