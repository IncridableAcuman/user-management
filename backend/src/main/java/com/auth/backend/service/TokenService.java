package com.auth.backend.service;

import com.auth.backend.entity.TokenEntity;
import com.auth.backend.entity.UserEntity;
import com.auth.backend.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;

    @Transactional
    public void createToken(UserEntity user,String refreshToken){
        TokenEntity token = new TokenEntity();
        token.setUser(user);
        token.setRefreshToken(refreshToken);
        token.setExpiration(LocalDateTime.now().plusDays(7));
        tokenRepository.save(token);
    }
}
