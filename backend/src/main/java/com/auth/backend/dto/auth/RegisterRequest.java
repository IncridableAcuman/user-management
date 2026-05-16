package com.auth.backend.dto.auth;

import com.auth.backend.entity.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "Firstname must be required")
    @Size(min = 3,max = 50,message = "Firstname must be between 3 and 50 characters long")
    private String firstName;
    @NotBlank(message = "Lastname must be required")
    @Size(min = 3,max = 50,message = "Lastname must be between 3 and 50 characters long")
    private String lastName;
    @NotBlank(message = "Lastname must be required")
    @Size(min = 3,max = 50,message = "Lastname must be between 3 and 50 characters long")
    private String username;
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Password must be required")
    @Size(min = 8,max = 50,message = "Password must be between 8 and 50 characters long")
    private String password;
    @NotNull(message = "Gender must be required")
    private Gender gender;
}
