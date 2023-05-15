package com.skyworth.login.controller;

import com.skyworth.login.service.UnifyLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @ClassName UnifyLoginCallbackController
 * @Description TODO
 * @Author sky
 * @Date 2023/5/15 10:31
 * @Version 1.0
 **/
@Controller
@RequestMapping("/v1/oa/")
public class UnifyLoginCallbackController {

    @Resource
    private UnifyLoginService unifyLoginService;


    @GetMapping("{callbackType}/logincallback")
    @ResponseBody
    public ModelAndView oauthLoginCallback(@PathVariable("callbackType") String callbackType,
                                           @RequestParam("code") String code, @RequestParam("state") String state) {
        return unifyLoginService.oauthLoginCallback(callbackType, code, state);
    }
}
