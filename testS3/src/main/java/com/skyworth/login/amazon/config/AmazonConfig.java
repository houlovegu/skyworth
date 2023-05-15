package com.skyworth.login.amazon.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName AmazonConfig
 * @Description TODO
 * @Author sky
 * @Date 2023/5/15 10:13
 * @Version 1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "oa.amazon")
@Data
public class AmazonConfig {


    private String authUrl;

    private String tokenUrl;

    private String clientId;

    private String clientSecret;

    private String redirectUrl;

    private String scopes;

    private String responseType;

    private String user_profileUrl;
}
