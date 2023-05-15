package com.skyworth.oauth.model;


/**
 * @Author sky
 * @Description //TODO
 * @Date 2023/5/15 15:31
 * @Param
 * @return
 **/
public class OauthCodeRequest {

    private String clientID;
    private String redirectUri;
    private String responseType;
    private String scope;
    private String state;

    public OauthCodeRequest(String clientID, String redirectUri, String responseType, String scope, String state) {
        this.clientID = clientID;
        this.redirectUri = redirectUri;
        this.responseType = responseType;
        this.scope = scope;
        this.state = state;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
