package com.skyworth.oltu.oauth2.service;


import com.skyworth.oltu.oauth2.Profile;
import org.apache.oltu.oauth2.common.token.OAuthToken;

/**
 * @Author sky
 * @Description //TODO 
 * @Date 2023/5/12 15:41
 * @Param 
 * @return 
 **/ 
public interface OauthLoginInterface {

    /**
     * 生成授权地址
     *
     * @param state
     * @return
     */
    String redirectUrl(String state);

    /**
     * 通过code 获取token
     *
     * @param code
     * @return
     */
    OAuthToken getToken(String code);

    /**
     * 获取用户资料
     *
     * @param accessToken
     * @return
     */
    Profile getProfile(String accessToken);
}
