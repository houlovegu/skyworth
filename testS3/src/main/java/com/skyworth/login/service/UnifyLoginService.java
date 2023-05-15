package com.skyworth.login.service;

import com.skyworth.web.response.R;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName UnifyLoginService
 * @Description TODO
 * @Author sky
 * @Date 2023/5/15 10:06
 * @Version 1.0
 **/
public interface UnifyLoginService {

    R parseLogin(String loginType);

    ModelAndView oauthLoginCallback(String callbackType, String code, String state);
}
