package com.auth.backend.service;

import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.dto.auth.UploadAvatar;
import com.auth.backend.entity.UserEntity;
import com.auth.backend.exception.CustomNotFoundException;
import com.auth.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserRepository userRepository;
    private final FileService fileService;

    @Transactional
    public void uploadAvatar(Long id,UploadAvatar avatar){
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
        user.setAvatar(fileService.saveFile(avatar.getAvatar()));
        userRepository.save(user);
    }
    @Transactional
    public void removeAvatar(Long id){
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
        fileService.removeFile(user.getAvatar());
        user.setAvatar(null);
        userRepository.save(user);
    }
}
