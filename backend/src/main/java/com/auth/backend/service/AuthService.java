package com.auth.backend.service;

import com.auth.backend.constant.EnvironmentValues;
import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.dto.auth.*;
import com.auth.backend.entity.UserEntity;
import com.auth.backend.entity.enums.UserRole;
import com.auth.backend.exception.CustomBadRequestException;
import com.auth.backend.exception.CustomNotFoundException;
import com.auth.backend.exception.CustomUnauthorizedException;
import com.auth.backend.producer.RabbitMQProducer;
import com.auth.backend.repository.UserRepository;
import com.auth.backend.util.CookieUtil;
import com.auth.backend.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RabbitMQProducer rabbitMQProducer;
    private final TokenService tokenService;
    private final EnvironmentValues environmentValues;
    private final RedisService redisService;

    public void register(RegisterRequest request){
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
        saveUser(user);

        sendOTP(user.getEmail());

    }
    public AuthResponse login(LoginRequest request,HttpServletResponse response){
        UserEntity user = findUserByEmail(request.getEmail());
        if (!user.isEnabled()){
            throw new CustomBadRequestException(ResponseMessage.NOT_VERIFIED);
        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new CustomBadRequestException(ResponseMessage.MISMATCH_PASSWORD);
        }
        String accessToken = jwtUtil.generateAccessToken(user);
        String refreshToken = jwtUtil.generateRefreshToken(user);

        tokenService.saveToken(user,refreshToken);

        cookieUtil.addCookie(refreshToken,response);

        return AuthResponse.from(accessToken);
    }
    public AuthResponse refresh(String refreshToken,HttpServletResponse response){
        UserEntity user = jwtUtil.extractUser(refreshToken);
        if (!jwtUtil.validateToken(refreshToken,user.getEmail())){
            throw new CustomUnauthorizedException(ResponseMessage.INVALID_TOKEN);
        }
        String newAccessToken = jwtUtil.generateAccessToken(user);
        String newRefreshToken = jwtUtil.generateRefreshToken(user);

        tokenService.saveToken(user,newRefreshToken);
        cookieUtil.addCookie(newRefreshToken,response);

        return AuthResponse.from(newAccessToken);
    }
    public void logout(String refreshToken,HttpServletResponse response){
        UserEntity user = jwtUtil.extractUser(refreshToken);
        if (!jwtUtil.validateToken(refreshToken,user.getEmail())){
            throw new CustomUnauthorizedException(ResponseMessage.INVALID_TOKEN);
        }
        tokenService.removeToken(user);
        cookieUtil.clearCookie(response);
    }
    public void forgotPassword(ForgotPasswordRequest request){
        UserEntity user = findUserByEmail(request.getEmail());
        String token = jwtUtil.generateAccessToken(user);
        String url = environmentValues.getClientUrl() + "/reset-password?token=" + token;

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
        saveUser(user);
    }

    public void verifyEmail(String email,String otp){
        String cacheOTP = redisService.getOTP(email);
        if (cacheOTP == null || !cacheOTP.equals(otp)){
            throw new CustomBadRequestException(ResponseMessage.INVALID_OTP);
        }
        UserEntity user = findUserByEmail(email);
        user.setEnabled(true);
        saveUser(user);
    }

    public void sendOTP(String email){
        UserEntity user = findUserByEmail(email);

        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        String stringOPTValue = String.valueOf(otp);
        redisService.saveOTP(user.getEmail(), stringOPTValue);
        EmailPayload payload = new EmailPayload(user.getEmail(),"Check this OTP",stringOPTValue);
        rabbitMQProducer.sendMessageWithRabbitMQ(payload);
    }

    public UserEntity findUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()-> new CustomNotFoundException(ResponseMessage.NOT_FOUND));
    }

    @Transactional
    public void saveUser(UserEntity user){
        userRepository.save(user);
    }
}
