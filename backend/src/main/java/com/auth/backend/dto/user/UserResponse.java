package com.auth.backend.dto.user;

import com.auth.backend.entity.enums.Gender;
import com.auth.backend.entity.enums.UserRole;

import java.time.LocalDateTime;
import java.util.Date;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String username,
        String email,
        UserRole role,
        Gender gender,
        String phone,
        boolean enabled,
        String avatar,
        Date birthDate,
        String bio,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}
