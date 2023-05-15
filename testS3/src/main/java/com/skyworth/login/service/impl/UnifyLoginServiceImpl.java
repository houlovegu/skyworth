package com.skyworth.login.service.impl;

import com.skyworth.login.amazon.service.AmazonAuthService;
import com.skyworth.login.service.UnifyLoginService;
import com.skyworth.redis.util.RedisUtils;
import com.skyworth.web.response.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @ClassName UnifyLoginServiceImpl
 * @Description 统一登录逻辑校验
 * @Author sky
 * @Date 2023/5/15 10:07
 * @Version 1.0
 **/
@Service
public class UnifyLoginServiceImpl implements UnifyLoginService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    AmazonAuthService amazonAuthService;

    @Override
    public R parseLogin(String loginType) {
        String oaUrl = null;
        switch (loginType) {
            case "amazon":
                oaUrl = amazonAuthService.login();
                break;
            default:

        }
        return R.success(oaUrl);
    }

    @Override
    public ModelAndView oauthLoginCallback(String callbackType, String code, String state) {
        ModelAndView mv = null;
        log.info("loginCallback response msg: {}, {} ,{}", callbackType, code, state);
        return mv;
    }
}
