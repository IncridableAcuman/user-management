package com.auth.backend.mapper;

import com.auth.backend.dto.user.UserResponse;
import com.auth.backend.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toDto(UserEntity user);

    UserEntity toEntity(UserResponse dto);
}
