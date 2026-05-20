package com.auth.backend.constant;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Data
@Getter
public final class EnvironmentValues {
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.access_time}")
    private int accessTime;
    @Value("${jwt.refresh_time}")
    private int refreshTime;
    @Value("${client.url}")
    private String clientUrl;
    @Value("${file.upload.dir}")
    public String uploadDir;

}
