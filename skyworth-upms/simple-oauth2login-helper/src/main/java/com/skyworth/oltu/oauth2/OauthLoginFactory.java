package com.skyworth.oltu.oauth2;



import com.skyworth.oltu.oauth2.service.OauthLoginInterface;
import com.skyworth.oltu.oauth2.service.impl.AmazonOauthLogin;
import com.skyworth.oltu.oauth2.service.impl.GoogleOauthLogin;
import com.skyworth.oltu.oauth2.service.impl.SkyworthOauthLogin;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Author sky
 * @Description //TODO 
 * @Date 2023/5/12 15:29
 * @Param 
 * @return 
 **/ 
@Component
public class OauthLoginFactory {

    @Resource
    private AmazonOauthLogin amazonOauthLoginMapping;
    private static AmazonOauthLogin amazonOauthLogin;

    @Resource
    private GoogleOauthLogin googleOauthLoginMapping;
    private static GoogleOauthLogin googleOauthLogin;

    @Resource
    private SkyworthOauthLogin skyworthOauthLoginMapping;
    private static SkyworthOauthLogin skyworthOauthLogin;


    @PostConstruct
    public void init() {
        amazonOauthLogin = amazonOauthLoginMapping;
        googleOauthLogin = googleOauthLoginMapping;
        skyworthOauthLogin = skyworthOauthLoginMapping;
    }


    public static OauthLoginInterface createOauthHelper(String oauthType) {
        OauthLoginInterface helper = null;
        switch (oauthType) {
            case "amazon":
                helper = amazonOauthLogin;
                break;
            case "google":
                helper = googleOauthLogin;
                break;
            case "skyworth":
                helper = skyworthOauthLogin;
            default:
        }
        return helper;
    }
}
