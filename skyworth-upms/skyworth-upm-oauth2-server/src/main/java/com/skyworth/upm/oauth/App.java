package com.skyworth.upm.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName App
 * @Description 启动类
 * @Author sky
 * @Date 2023/5/15 11:28
 * @Version 1.0
 **/
@SpringBootApplication(scanBasePackages = "com.skyworth")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
