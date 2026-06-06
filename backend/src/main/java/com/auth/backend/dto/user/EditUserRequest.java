package com.auth.backend.dto.user;

import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.entity.enums.Gender;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EditUserRequest {
    @Size(min = 3,max = 50,message = ResponseMessage.FIRST_NAME_REQUIRED_LENGTH)
    private String firstName;

    @Size(min = 3,max = 50,message = ResponseMessage.LAST_NAME_REQUIRED_LENGTH)
    private String lastName;

    @Size(min = 3,max = 50,message = ResponseMessage.USER_NAME_REQUIRED_LENGTH)
    private String username;

    private Gender gender;

    private Date birthDate;

    private String phone;
    @Size(max = 500,message = ResponseMessage.BIO_MAX_LENGTH)
    private String bio;

    private String country;

    private List<String> skills;

    private List<String> socialLinks;
}
