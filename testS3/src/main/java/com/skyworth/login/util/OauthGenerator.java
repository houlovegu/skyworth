package com.skyworth.login.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OauthGenerator {

    static final String CODE_PREFIX = "CODE|";
    static final String STATE_PREFIX = "STATE|";
    static final String ACCESS_TOKEN_PREFIX = "ACC|";
    static final String REFRESH_TOKEN_PREFIX = "REF|";


    public static String generateState() {
        return STATE_PREFIX + UUID.randomUUID().toString();
    }

    public static String generateCode() {
        return CODE_PREFIX + UUID.randomUUID().toString();
    }

    public static String generateAccessToken() {
        return ACCESS_TOKEN_PREFIX + UUID.randomUUID().toString();
    }

    public static String generateRefreshToken() {
        return REFRESH_TOKEN_PREFIX + UUID.randomUUID().toString();
    }
}
