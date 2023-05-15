package com.skyworth.login.controller;

import com.skyworth.login.service.UnifyLoginService;
import com.skyworth.web.response.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @ClassName UnifLoginController
 * @Description TODO
 * @Author sky
 * @Date 2023/5/15 10:03
 * @Version 1.0
 **/
@RestController
@RequestMapping("/skyworth")
public class UnifyLoginController {

    @Resource
    UnifyLoginService unifyLoginService;

    @GetMapping("/login")
    public R parseLogin(@RequestParam String loginType) {
        return unifyLoginService.parseLogin(loginType);
    }
}
