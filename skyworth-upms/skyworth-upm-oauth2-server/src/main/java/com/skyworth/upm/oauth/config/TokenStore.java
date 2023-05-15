package com.skyworth.upm.oauth.config;

import com.skyworth.oauth.model.OauthState;
import com.skyworth.redis.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class TokenStore {


    private final String QRCODE_LOGIN_PREFIX = "qrcode_login_even:";
    private final String OAUTH_TOKEN_PREFIX = "oauth_account_token:";
    private final String OAUTH_STATE_PREFIX = "oauth_state:";
    private final String OAUTH_CODE_PREFIX = "oauth_server_code:";

    private final String OAUTH_SERVER_TOKEN_PREFIX = "oauth_server_token:";
    private final String OAUTH_CLIENT_TOKEN_PREFIX = "oauth_client_token:";

    private final String OAUTH_ACCESS_TOKEN = "access_token:";
    private final String OAUTH_REFRESH_TOKEN = "refresh_token:";


    @Value("${oauth.qrcode.timeout}")
    private long qrcodeTimeout;
    @Value("${oauth.server.code.timeout}")
    private long oauthCodeTimeout;
    @Value("${oauth.server.state.timeout}")
    private long oauthStateTimeout;


    @Resource
    private RedisUtils redisUtils;

//    public void storeQrcodeLoginEven(String sessionId, QcodeLoginEven even) {
//        redisTemplate.opsForValue().set(QRCODE_LOGIN_PREFIX + sessionId, even, qrcodeTimeout, TimeUnit.SECONDS);
//    }
//
//    public QcodeLoginEven getQrcodeLoginEven(String sessionId) {
//        return (QcodeLoginEven) redisTemplate.opsForValue().get(QRCODE_LOGIN_PREFIX + sessionId);
//    }

    public void storeOauthState(String stateId, OauthState state) {
        redisUtils.set(OAUTH_STATE_PREFIX + stateId, state, oauthStateTimeout);
    }

    public OauthState getOauthState(String stateId) {
        return (OauthState) redisUtils.get(OAUTH_STATE_PREFIX + stateId);
    }

//    public void storeOauthCode(String code, OauthCode oauthCode) {
//        redisTemplate.opsForValue().set(OAUTH_CODE_PROFIX + code, oauthCode, oauthCodeTimeout, TimeUnit.SECONDS);
//    }
//
//    public OauthCode getOauthCode(String code) {
//        return (OauthCode) redisTemplate.opsForValue().get(OAUTH_CODE_PROFIX + code);
//    }
//
//    /**
//     * 保存 token信息
//     * 包括 access token，refresh token ，授权时的信息
//     * 目前以refresh token作为主键，
//     *
//     * @param entity
//     */
//    public void storeAccessToken(TokenStoreModel entity) {
//        AccessToken accessToken = entity.getAccessToken();
//        RefreshToken refreshToken = entity.getRefreshToken();
//        redisTemplate.opsForValue().set(OAUTH_ACCESS_TOKEN + accessToken.getAccessToken(), accessToken, accessToken.getExpiresIn(), TimeUnit.SECONDS);
//
//        if (refreshToken.getExpireIn() == 0) {
//            redisTemplate.opsForValue().set(OAUTH_REFRESH_TOKEN + refreshToken.getRefreshToken(), entity);
//        } else {
//            redisTemplate.opsForValue().set(OAUTH_REFRESH_TOKEN + refreshToken.getRefreshToken(), entity, refreshToken.getExpireIn(), TimeUnit.SECONDS);
//        }
//    }
//
//    public TokenStoreModel getTokenStoreByRefreshToken(String refreshToken) {
//        return get(OAUTH_REFRESH_TOKEN + refreshToken, TokenStoreModel.class);
//    }
//
//
//    public AccessToken delToken(String token) {
//        String key = OAUTH_ACCESS_TOKEN + token;
//        AccessToken accessToken = (AccessToken) redisTemplate.opsForValue().get(key);
//        del(OAUTH_ACCESS_TOKEN + token);
//        return accessToken;
//    }
//
//    public TokenStoreModel getTokenStoreByToken(String token) {
//        AccessToken accessToken = get(OAUTH_ACCESS_TOKEN + token, AccessToken.class);
//        if (accessToken == null) {
//            return null;
//        }
//        String refreshToken = accessToken.getRefreshToken();
//
//        return getTokenStoreByRefreshToken(refreshToken);
//    }


    public <T> T get(String key, Class<T> type) {
        return (T) redisUtils.get(key);
    }


    private void del(String key) {
        redisUtils.del(key);
    }
}
