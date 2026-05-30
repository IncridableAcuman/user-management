package com.auth.backend.controller;

import com.auth.backend.constant.Endpoint;
import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.dto.auth.*;
import com.auth.backend.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Endpoint.AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(Endpoint.REGISTER)
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request){
        authService.register(request);
        return ResponseEntity.ok(ResponseMessage.SUCCESS);
    }
    @PostMapping(Endpoint.LOGIN)
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request,HttpServletResponse response){
        return ResponseEntity.ok(authService.login(request,response));
    }
    @GetMapping(Endpoint.REFRESH)
    public ResponseEntity<AuthResponse> refresh(@CookieValue(name = "refreshToken",required = false) String refreshToken,HttpServletResponse response){
        return ResponseEntity.ok(authService.refresh(refreshToken,response));
    }
    @PostMapping(Endpoint.LOGOUT)
    public ResponseEntity<String> logout(@CookieValue(name = "refreshToken",required = false) String refreshToken,HttpServletResponse response){
        authService.logout(refreshToken,response);
        return ResponseEntity.ok(ResponseMessage.SUCCESS);
    }
    @PostMapping(Endpoint.FORGOT_PASSWORD)
    public ResponseEntity<String> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request){
        authService.forgotPassword(request);
        return ResponseEntity.ok(ResponseMessage.SUCCESS);
    }
    @PatchMapping(Endpoint.RESET_PASSWORD)
    public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordRequest request){
        authService.resetPassword(request);
        return ResponseEntity.ok(ResponseMessage.SUCCESS);
    }
    @GetMapping(Endpoint.VERIFY_EMAIL)
    public ResponseEntity<String> verifyEmail(@RequestParam String token){
        authService.verifyEmail(token);
        return ResponseEntity.ok(ResponseMessage.SUCCESS);
    }
}
