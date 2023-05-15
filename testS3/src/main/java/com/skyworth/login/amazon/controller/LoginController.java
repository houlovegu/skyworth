package com.skyworth.login.amazon.controller;

import com.skyworth.login.amazon.entity.AmzAuthRequest;
import com.skyworth.login.amazon.service.AmazonAuthService;
import com.skyworth.web.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @ClassName LoginController
 * @Description LoginController
 * @Author sky
 * @Date 2023/5/12 10:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("/amazon")
public class LoginController {

    @Resource
    AmazonAuthService amazonAuthService;
}

