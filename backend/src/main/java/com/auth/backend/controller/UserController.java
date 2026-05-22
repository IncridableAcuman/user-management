package com.auth.backend.controller;

import com.auth.backend.constant.Endpoint;
import com.auth.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoint.USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
}
