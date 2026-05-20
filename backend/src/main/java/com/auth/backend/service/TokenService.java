package com.auth.backend.service;

import com.auth.backend.entity.TokenEntity;
import com.auth.backend.entity.UserEntity;
import com.auth.backend.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;

    public Optional<TokenEntity> findTokenByUser(UserEntity user){
        return tokenRepository.findByUser(user);
    }

    @Transactional
    public void saveToken(UserEntity user,String refreshToken){
        Optional<TokenEntity> optionalToken = findTokenByUser(user);
        TokenEntity token = optionalToken.orElseGet(TokenEntity::new);
        token.setUser(user);
        token.setRefreshToken(refreshToken);
        token.setExpiration(LocalDateTime.now().plusDays(7));
        tokenRepository.save(token);
    }

    @Transactional
    public void removeToken(UserEntity user){
        TokenEntity token = findTokenByUser(user).orElseThrow();
        tokenRepository.delete(token);
    }
}
