package com.auth.backend.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {
    @Value("${jwt.refresh_time}")
    private int refreshTime;

    private static  void cookieManagement(String refreshToken,int expiration, HttpServletResponse response){
        Cookie cookie = new Cookie("refreshToken",refreshToken);
        cookie.setValue(refreshToken);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(expiration);

        response.addCookie(cookie);
    }
    public void addCookie(String refreshToken,HttpServletResponse response){
        cookieManagement(refreshToken,refreshTime,response);
    }
    public void clearCookie(HttpServletResponse response){
        cookieManagement(null,0,response);
    }
}
