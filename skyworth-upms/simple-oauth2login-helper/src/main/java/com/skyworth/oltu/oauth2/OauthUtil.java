package com.skyworth.oltu.oauth2;

import java.util.UUID;

public class OauthUtil {

    public static String generateOauthCode(String... args) {
        return UUID.randomUUID().toString();
    }
}
