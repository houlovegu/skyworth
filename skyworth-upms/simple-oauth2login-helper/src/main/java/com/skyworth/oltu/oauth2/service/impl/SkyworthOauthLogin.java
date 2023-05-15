package com.skyworth.oltu.oauth2.service.impl;


import com.skyworth.oltu.oauth2.Profile;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author sky
 * @Description //TODO 
 * @Date 2023/5/12 15:33
 * @Param 
 * @return 
 **/ 
@Component
@ConfigurationProperties(prefix = "oa.skyworth")
public class SkyworthOauthLogin extends AbstractOauthLogin {

    private String authUrl;
    private String tokenUrl;
    private String clientId;
    private String clientSecret;
    private String redirectUrl;
    private String scopes;
    private String responseType;

    private String userProfileUrl;

    public String getUserProfileUrl() {
        return userProfileUrl;
    }

    @Override
    public Profile getProfile(String accessToken) {
        return null;
    }

    public void setUserProfileUrl(String userProfileUrl) {
        this.userProfileUrl = userProfileUrl;
    }

    @Override
    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    @Override
    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    @Override
    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
