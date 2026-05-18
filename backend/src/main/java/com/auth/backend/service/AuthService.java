package com.auth.backend.service;

import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.dto.auth.*;
import com.auth.backend.entity.TokenEntity;
import com.auth.backend.entity.UserEntity;
import com.auth.backend.entity.enums.UserRole;
import com.auth.backend.exception.CustomBadRequestException;
import com.auth.backend.exception.CustomNotFoundException;
import com.auth.backend.exception.CustomUnauthorizedException;
import com.auth.backend.producer.RabbitMQProducer;
import com.auth.backend.repository.TokenRepository;
import com.auth.backend.repository.UserRepository;
import com.auth.backend.util.CookieUtil;
import com.auth.backend.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final RabbitMQProducer rabbitMQProducer;

    public AuthResponse register(RegisterRequest request, HttpServletResponse response){
        if (userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new CustomBadRequestException(ResponseMessage.EXIST_USER);
        }
        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(UserRole.USER);
        user.setGender(request.getGender());
        userRepository.save(user);

        String accessToken = jwtUtil.generateAccessToken(user);
        String refreshToken = jwtUtil.generateRefreshToken(user);

        TokenEntity token = new TokenEntity();
        token.setUser(user);
        token.setRefreshToken(refreshToken);
        token.setExpiration(LocalDateTime.now().plusDays(7));
        tokenRepository.save(token);

        cookieUtil.addCookie(refreshToken,response);

        return AuthResponse.from(accessToken);
    }
    public AuthResponse login(LoginRequest request,HttpServletResponse response){
        UserEntity user = userRepository.findByEmail(request.getEmail()).orElseThrow(()->new CustomNotFoundException(ResponseMessage.NOT_FOUND));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new CustomBadRequestException(ResponseMessage.MISMATCH_PASSWORD);
        }
        String accessToken = jwtUtil.generateAccessToken(user);
        String refreshToken = jwtUtil.generateRefreshToken(user);

        TokenEntity token = new TokenEntity();
        token.setUser(user);
        token.setRefreshToken(refreshToken);
        token.setExpiration(LocalDateTime.now().plusDays(7));
        tokenRepository.save(token);

        cookieUtil.addCookie(refreshToken,response);

        return AuthResponse.from(accessToken);
    }
    public AuthResponse refresh(String refreshToken,HttpServletResponse response){
        UserEntity user = jwtUtil.extractUser(refreshToken);
        if (!jwtUtil.validateToken(refreshToken,user.getEmail())){
            throw new CustomUnauthorizedException(ResponseMessage.INVALID_TOKEN);
        }
        TokenEntity existToken = tokenRepository.findByRefreshToken(refreshToken).orElseThrow();
        tokenRepository.delete(existToken);
        String newAccessToken = jwtUtil.generateAccessToken(user);
        String newRefreshToken = jwtUtil.generateRefreshToken(user);

        TokenEntity token = new TokenEntity();
        token.setUser(user);
        token.setRefreshToken(newRefreshToken);
        token.setExpiration(LocalDateTime.now().plusDays(7));
        tokenRepository.save(token);

        cookieUtil.addCookie(refreshToken,response);

        return AuthResponse.from(newAccessToken);
    }
    public void logout(String refreshToken,HttpServletResponse response){
        UserEntity user = jwtUtil.extractUser(refreshToken);
        if (!jwtUtil.validateToken(refreshToken,user.getEmail())){
            throw new CustomUnauthorizedException(ResponseMessage.INVALID_TOKEN);
        }
        cookieUtil.clearCookie(response);
        TokenEntity token = tokenRepository.findByRefreshToken(refreshToken).orElseThrow();
        tokenRepository.delete(token);
    }
    public void forgotPassword(ForgotPasswordRequest request){
        UserEntity user = userRepository.findByEmail(request.getEmail()).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
        String token = jwtUtil.generateAccessToken(user);
        String url = "http://localhost:5173/reset-password?token=" + token;

        EmailPayload payload = new EmailPayload(user.getEmail(),"Reset Password",url);
        rabbitMQProducer.sendMessageWithRabbitMQ(payload);
    }
    public void resetPassword(ResetPasswordRequest request){
        if (!request.getPassword().equals(request.getConfirmPassword())){
            throw new CustomBadRequestException(ResponseMessage.MISMATCH_PASSWORD);
        }
        if (jwtUtil.isTokenExpired(request.getToken())){
            throw new CustomBadRequestException(ResponseMessage.EXPIRED_TOKEN);
        }
        UserEntity user = jwtUtil.extractUser(request.getToken());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }
}
