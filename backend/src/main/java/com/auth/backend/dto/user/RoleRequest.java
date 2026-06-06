package com.auth.backend.dto.user;

import com.auth.backend.entity.enums.UserRole;
import lombok.Data;

@Data
public class RoleRequest {
    UserRole role;
}
