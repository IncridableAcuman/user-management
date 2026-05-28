package com.auth.backend.controller;

import com.auth.backend.constant.Endpoint;
import com.auth.backend.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoint.USER)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;
}
