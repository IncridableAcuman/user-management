package com.auth.backend.service;

import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.dto.user.EditUserRequest;
import com.auth.backend.dto.user.UserResponse;
import com.auth.backend.entity.UserEntity;
import com.auth.backend.exception.CustomNotFoundException;
import com.auth.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserRepository userRepository;
    private final FileService fileService;

    @Transactional
    public void uploadAvatar(Long id, MultipartFile avatar){
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
        String avatarName=null;
        if (avatar != null){
            avatarName = fileService.saveFile(avatar);
        }
        Optional.ofNullable(avatarName).ifPresent(user::setAvatar);
        userRepository.save(user);
    }

    @Transactional
    public void removeAvatar(Long id){
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
        fileService.removeFile(user.getAvatar());
        user.setAvatar(null);
        userRepository.save(user);
    }

    @Transactional
    public UserResponse editUser(Long id, EditUserRequest request){
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
        Optional.ofNullable(request.getFirstName()).ifPresent(user::setFirstName);
        Optional.ofNullable(request.getLastName()).ifPresent(user::setLastName);
        Optional.ofNullable(request.getUsername()).ifPresent(user::setUsername);
        Optional.ofNullable(request.getBirthDate()).ifPresent(user::setBirthDate);
        Optional.ofNullable(request.getBio()).ifPresent(user::setBio);
        Optional.ofNullable(request.getCountry()).ifPresent(user::setCountry);
        Optional.ofNullable(request.getGender()).ifPresent(user::setGender);
        Optional.ofNullable(request.getSkills()).ifPresent(user::setSkills);
        Optional.ofNullable(request.getSocialLinks()).ifPresent(user::setSocialLinks);
        Optional.ofNullable(request.getPhone()).ifPresent(user::setPhone);

        return UserResponse.from(user);
    }
}
