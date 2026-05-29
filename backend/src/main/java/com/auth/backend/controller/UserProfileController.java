package com.auth.backend.controller;

import com.auth.backend.constant.Endpoint;
import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.dto.auth.UploadAvatar;
import com.auth.backend.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Endpoint.USER)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping("/{id}/avatar")
    public ResponseEntity<String> uploadAvatar(@PathVariable Long id, @ModelAttribute UploadAvatar avatar){
        userProfileService.uploadAvatar(id,avatar);
        return ResponseEntity.ok(ResponseMessage.SUCCESS);
    }
    @PostMapping("/{id}/avatar/remove")
    public ResponseEntity<String> removeAvatar(@PathVariable Long id){
        userProfileService.removeAvatar(id);
        return ResponseEntity.ok(ResponseMessage.SUCCESS);
    }
}
