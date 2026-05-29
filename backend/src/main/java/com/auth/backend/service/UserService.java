package com.auth.backend.service;

import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.dto.user.EditUserRequest;
import com.auth.backend.dto.user.UserResponse;
import com.auth.backend.entity.UserEntity;
import com.auth.backend.exception.CustomNotFoundException;
import com.auth.backend.mapper.UserMapper;
import com.auth.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse getMe(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        UserEntity user = (UserEntity) authentication.getPrincipal();
        assert user != null;

        return  userMapper.toDto(user);
    }

    @Transactional
    public void removeUser(Long id){
        UserEntity user = getUserById(id);
        userRepository.delete(user);
    }

    @Transactional
    public List<UserResponse> getList(){
        List<UserEntity> list = userRepository.findAll();
        return list
                .stream()
                .map(userMapper::toDto).toList();
    }

    public UserEntity getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
    }

    @Transactional
    public UserResponse editUser(Long id, EditUserRequest request){
        UserEntity user = getUserById(id);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setGender(request.getGender());
        user.setBirthDate(request.getBirthDate());
        user.setBio(request.getBio());
        user.setPhone(request.getPhone());
        UserEntity saved = userRepository.save(user);
        return userMapper.toDto(saved);
    }
}
