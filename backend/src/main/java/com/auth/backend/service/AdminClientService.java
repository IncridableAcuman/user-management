package com.auth.backend.service;

import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.dto.user.RoleRequest;
import com.auth.backend.entity.UserEntity;
import com.auth.backend.exception.CustomNotFoundException;
import com.auth.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminClientService {
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Transactional
    public void editRole(Long id, RoleRequest request){
        UserEntity user = findUserById(id);
        user.setRole(request.getRole());
        userRepository.save(user);
    }
    @Transactional
    public void removeUser(Long id){
        UserEntity user = findUserById(id);
        tokenService.removeToken(user);
        userRepository.delete(user);
    }
    public UserEntity findUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
    }
}
