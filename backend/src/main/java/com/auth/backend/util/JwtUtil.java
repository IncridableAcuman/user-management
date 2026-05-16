package com.auth.backend.util;

import com.auth.backend.entity.UserEntity;
import com.auth.backend.exception.CustomNotFoundException;
import com.auth.backend.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtUtil {
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.access_time}")
    private int accessTime;
    @Value("${jwt.refresh_time}")
    private int refreshTime;
    private Key key;

    private final UserRepository userRepository;

    @PostConstruct
    public void init(){
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(UserEntity user){
        Map<String,Object> claims = new HashMap<>();

        claims.put("id",user.getId());
        claims.put("email",user.getEmail());
        claims.put("role",user.getRole());

        long currentMillis = System.currentTimeMillis();
        Date issueAt = new Date(currentMillis);
        Date expiration = new Date(accessTime + currentMillis);

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(issueAt)
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }
    public String generateRefreshToken(UserEntity user){
        Map<String,Object> claims = new HashMap<>();

        claims.put("id",user.getId());
        claims.put("email",user.getEmail());
        claims.put("role",user.getRole());

        long currentMillis = System.currentTimeMillis();
        Date issueAt = new Date(currentMillis);
        Date expiration = new Date(refreshTime + currentMillis);

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(issueAt)
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }

    public Claims extractClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractEmail(String token){
        return extractClaims(token).getSubject();
    }
    public Date extractExpiration(String token){
        return extractClaims(token).getExpiration();
    }
    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public boolean validateToken(String token,String subject){
        try {
            UserEntity user = extractUser(token);
            return user.getEmail().equals(subject) && !isTokenExpired(token);
        } catch (Exception e){
            return false;
        }
    }
    public UserEntity extractUser(String token){
        String email = extractEmail(token);
        return userRepository.findByEmail(email).orElseThrow(()-> new CustomNotFoundException("User not found"));
    }
}
