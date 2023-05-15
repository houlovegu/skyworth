package com.skyworth.upm.oauth.login.service;

import com.skyworth.web.response.R;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName LoginService
 * @Description LoginService
 * @Author sky
 * @Date 2023/5/15 11:39
 * @Version 1.0
 **/
public interface LoginService {

    /**
     * @Author sky
     * @Description 第三方登录
     * @Date 2023/5/15 15:14
     * @Param [loginType] 登录类型
     * @return com.skyworth.web.response.R
     **/
    R loginByThird(String loginType);

    /**
     * @Author sky
     * @Description 登录回调接口
     * @Date 2023/5/15 15:14
     * @Param [callbackType: urlPathVariable:amazon,google, code:授权码, state:随机字符串]
     * @return com.skyworth.web.response.R
     **/
    R oauthLoginCallback(String callbackType, String code, String state);
}
