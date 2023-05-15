package com.skyworth.oltu.oauth2.service.impl;


import com.alibaba.fastjson.JSON;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.token.OAuthToken;
import com.skyworth.oltu.oauth2.service.OauthLoginInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author sky
 * @Description //TODO 
 * @Date 2023/5/12 15:32
 * @Param 
 * @return 
 **/
public abstract class AbstractOauthLogin implements OauthLoginInterface {

    private static final Logger log = LoggerFactory.getLogger(AbstractOauthLogin.class);

    private final static String SCOPE_SEPARATOR = ",";

    private String authUrl;
    private String tokenUrl;
    private String clientId;
    private String clientSecret;
    private String redirectUrl;
    private String scopes;
    private String responseType;


    @Override
    public String redirectUrl(String state) {
        try {
            OAuthClientRequest.AuthenticationRequestBuilder builder = OAuthClientRequest
                    .authorizationLocation(getAuthUrl())
                    .setClientId(getClientId())
                    .setRedirectURI(getRedirectUrl())
                    .setResponseType(getResponseType())
                    .setRedirectURI(getRedirectUrl())
                    .setState(state);
            for (String scope : getScopes().split(SCOPE_SEPARATOR)) {
                builder.setScope(scope);
            }
            OAuthClientRequest accessTokenRequest = builder.buildQueryMessage();
            return accessTokenRequest.getLocationUri();
        } catch (OAuthSystemException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OAuthToken getToken(String code) {
        try {
            OAuthClientRequest.TokenRequestBuilder builder = OAuthClientRequest.
                    tokenLocation(getTokenUrl())
                    .setClientId(getClientId())
                    .setCode(code)
                    .setClientSecret(getClientSecret())
                    .setGrantType(GrantType.AUTHORIZATION_CODE).setRedirectURI(getRedirectUrl());
            OAuthClientRequest tokenRequest = builder.buildBodyMessage();
            URLConnectionClient urlConnectionClient = new URLConnectionClient();
            Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", getAuthorization(getClientId(), getClientSecret()));
            OAuthJSONAccessTokenResponse tokenResponse = urlConnectionClient.execute(tokenRequest, headers, OAuth.HttpMethod.POST, OAuthJSONAccessTokenResponse.class);
            log.info("token response:{}", JSON.toJSONString(tokenResponse.getOAuthToken()));
            return tokenResponse.getOAuthToken();
        } catch (OAuthSystemException | OAuthProblemException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String getScopes() {
        return scopes;
    }

    public String getResponseType() {
        return responseType;
    }

    protected String getAuthorization(String Id, String Secret) {
        String str = Id + ":" + Secret;
        return "Basic " + Base64.getEncoder().encodeToString(str.getBytes());
    }
}
