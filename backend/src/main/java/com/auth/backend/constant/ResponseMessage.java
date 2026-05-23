package com.auth.backend.constant;

public final class ResponseMessage {
    private ResponseMessage(){}

    public static final String SUCCESS="success";
    public static final String NOT_FOUND="not found";
    public static final String SERVER_ERROR="internal server error";
    public static final String UNAUTHORIZED="unauthorized";
    public static final String INVALID_EMAIL="invalid email format";
    public static final String INVALID_TOKEN="invalid token";
    public static final String EXPIRED_TOKEN="token is expired";
    public static final String TOKEN_REQUIRED="token is required";
    public static final String FIRST_NAME_REQUIRED="firstname must be required";
    public static final String LAST_NAME_REQUIRED="lastname must be required";
    public static final String USER_NAME_REQUIRED="username must be required";
    public static final String PASSWORD_REQUIRED="password must be required";
    public static final String CONFIRM_PASSWORD_REQUIRED="confirm password must be required";
    public static final String GENDER_REQUIRED="gender must be required";
    public static final String FIRST_NAME_REQUIRED_LENGTH="firstname must be between 3 and 50 characters long";
    public static final String LAST_NAME_REQUIRED_LENGTH="lastname must be between 3 and 50 characters long";
    public static final String USER_NAME_REQUIRED_LENGTH="username must be between 3 and 50 characters long";
    public static final String PASSWORD_REQUIRED_LENGTH="password must be between 8 and 50 characters long";
    public static final String CONFIRM_PASSWORD_REQUIRED_LENGTH="confirm password must be between 8 and 50 characters long";
    public static final String EXIST_USER="user already exist";
    public static final String MISMATCH_PASSWORD="password is mismatch";
    public static final String VERIFIED_USER="already verified";
    public static final String NOT_VERIFIED="Not verified";
    public static final String INVALID_OTP = "invalid otp";
    public static final String NULL_EMAIL="email is null";
}
