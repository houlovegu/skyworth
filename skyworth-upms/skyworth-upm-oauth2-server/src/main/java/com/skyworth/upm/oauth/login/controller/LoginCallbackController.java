package com.skyworth.upm.oauth.login.controller;

import com.skyworth.upm.oauth.login.service.LoginService;
import com.skyworth.web.response.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName LoginCallbackController
 * @Description TODO
 * @Author sky
 * @Date 2023/5/15 15:02
 * @Version 1.0
 **/
@Api(tags = "登录模块")
@RestController
@RequestMapping("/v1/oa")
public class LoginCallbackController {

    @Resource
    LoginService loginService;


    @ApiOperation(value = "Oauth2.0登录回调", notes = "Oauth2.0登录回调")
    @GetMapping("/{callbackType}/logincallback")
    public R oauthLoginCallback(@PathVariable("callbackType") String callbackType, @RequestParam("code") String code, @RequestParam("state") String state) {
        return loginService.oauthLoginCallback(callbackType, code, state);
    }

}
