package com.auth.backend.service;

import com.auth.backend.constant.EnvironmentValues;
import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.exception.CustomBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final RedisTemplate<String,Object> template;
    private final EnvironmentValues environmentValues;

    public String getKey(String email){
        if (email == null){
            throw new CustomBadRequestException(ResponseMessage.NULL_EMAIL);
        }
        return "otp:"+email;
    }
    public void saveOTP(String email,String otp){
        if (otp.isEmpty()){
            throw new CustomBadRequestException(ResponseMessage.INVALID_OTP);
        }
       String key = getKey(email);
       template
               .opsForValue()
               .set(
                       key,
                       otp,
                       environmentValues.getOtpTime(),
                       TimeUnit.MILLISECONDS
               );
    }
    public String getOTP(String email){
        String key = getKey(email);
        Object otp = template.opsForValue().get(key);
        return otp != null ? otp.toString() : null;
    }
    public void removeOTP(String email){
        String key = getKey(email);
        template.delete(key);
    }
}
