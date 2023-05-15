package com.skyworth.upm.oauth.login.controller;

import com.skyworth.upm.oauth.login.service.LoginService;
import com.skyworth.web.response.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author sky
 * @Date 2023/5/15 11:36
 * @Version 1.0
 **/
@Api(tags = "登录模块")
@RestController
@RequestMapping("/v1/api")
public class LoginController {

    @Resource
    LoginService loginService;

    @ApiOperation("第三方登录[amazon/google]")
    @ApiImplicitParam(name = "loginType", value = "登录类型:亚马逊-amazon,谷歌-google", required = true, dataTypeClass = String.class)
    @GetMapping("/loginByThird")
    public R loginByThird(@Validated @RequestParam(name = "loginType", required = true) String loginType) {
        return loginService.loginByThird(loginType);
    }
}
