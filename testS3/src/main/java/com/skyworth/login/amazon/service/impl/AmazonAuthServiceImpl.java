package com.skyworth.login.amazon.service.impl;

import com.skyworth.login.amazon.config.AmazonConfig;
import com.skyworth.login.amazon.entity.AmzAuthRequest;
import com.skyworth.login.amazon.service.AmazonAuthService;
import com.skyworth.login.util.OauthGenerator;
import com.skyworth.redis.util.RedisUtils;
import com.skyworth.web.response.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @ClassName AmazonAuthServiceImpl
 * @Description TODO
 * @Author sky
 * @Date 2023/5/15 8:48
 * @Version 1.0
 * 为请求获取访问令牌，客户端会向以下区域终端节点之一发出安全HTTP POST请求：
 *
 * 北美洲(NA) - https://api.amazon.com/auth/o2/token
 * 欧盟(EU) - https://api.amazon.co.uk/auth/o2/token
 * 远东(FE) - https://api.amazon.co.jp/auth/o2/token
 **/
@Service
public class AmazonAuthServiceImpl implements AmazonAuthService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AmazonConfig amazonConfig;

    @Resource
    RedisUtils redisUtils;

    @Override
    public R doLogin(AmzAuthRequest amzAuthRequest) {
        log.info("接收到请求参数:{},{},{},{}",amzAuthRequest.getAccess_token(),amzAuthRequest.getToken_type(),amzAuthRequest.getExpires_in(),amzAuthRequest.getScope());
        return R.success(null);
    }

    @Override
    public String login() {
        String state = OauthGenerator.generateState();
        // 组装oaUrl
        String oaUrl = getOaUrl(state);
        return oaUrl;
    }

    public String getOaUrl(String state) {
        StringBuffer sb = new StringBuffer();
        sb.append(amazonConfig.getAuthUrl());
        sb.append("?client_id=").append(amazonConfig.getClientId());
        sb.append("&scope=").append(amazonConfig.getScopes());
        sb.append("&response_type=").append(amazonConfig.getResponseType());
        sb.append("&state=").append(state);
        sb.append("&redirect_uri=").append(amazonConfig.getRedirectUrl());
        return sb.toString();
    }
}
