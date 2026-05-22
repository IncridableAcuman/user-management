package com.auth.backend.dto.auth;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadAvatar {
    private MultipartFile avatar;
}
