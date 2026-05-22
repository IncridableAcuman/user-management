package com.auth.backend.service;

import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.dto.auth.UploadAvatar;
import com.auth.backend.dto.user.UserResponse;
import com.auth.backend.entity.UserEntity;
import com.auth.backend.exception.CustomNotFoundException;
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
    private final FileService fileService;

    public UserResponse getMe(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        UserEntity user = (UserEntity) authentication.getPrincipal();
        assert user != null;
        return UserResponse.from(user);
    }

    @Transactional
    public void removeUser(Long id){
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
        userRepository.delete(user);
    }

    @Transactional
    public List<UserResponse> getList(){
        List<UserEntity> list = userRepository.findAll();
        return list
                .stream()
                .map(UserResponse::from).toList();
    }

    public UserResponse getUserById(Long id){
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
        return UserResponse.from(user);
    }

    @Transactional
    public void uploadAvatar(Long id,UploadAvatar uploadAvatar){
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
        user.setAvatar(fileService.saveFile(uploadAvatar.getAvatar()));
        userRepository.save(user);
    }
}
