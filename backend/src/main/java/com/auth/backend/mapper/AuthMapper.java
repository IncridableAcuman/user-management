package com.auth.backend.mapper;

import com.auth.backend.dto.auth.AuthResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    AuthResponse toDto(String  accessToken);
}
