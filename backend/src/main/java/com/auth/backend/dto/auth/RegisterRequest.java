package com.auth.backend.dto.auth;

import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.entity.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = ResponseMessage.FIRST_NAME_REQUIRED)
    @Size(min = 3,max = 50,message = ResponseMessage.FIRST_NAME_REQUIRED_LENGTH)
    private String firstName;
    @NotBlank(message = ResponseMessage.LAST_NAME_REQUIRED)
    @Size(min = 3,max = 50,message = ResponseMessage.LAST_NAME_REQUIRED_LENGTH)
    private String lastName;
    @NotBlank(message = ResponseMessage.USER_NAME_REQUIRED)
    @Size(min = 3,max = 50,message = ResponseMessage.USER_NAME_REQUIRED_LENGTH)
    private String username;
    @Email(message = ResponseMessage.INVALID_EMAIL)
    private String email;
    @NotBlank(message = ResponseMessage.PASSWORD_REQUIRED)
    @Size(min = 8,max = 50,message = ResponseMessage.PASSWORD_REQUIRED_LENGTH)
    private String password;
    @NotNull(message = ResponseMessage.GENDER_REQUIRED)
    private Gender gender;
}
