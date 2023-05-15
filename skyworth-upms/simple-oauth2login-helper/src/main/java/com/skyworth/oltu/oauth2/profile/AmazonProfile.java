package com.skyworth.oltu.oauth2.profile;

import com.alibaba.fastjson.annotation.JSONField;
import com.skyworth.oltu.oauth2.Profile;

/**
 * @Author sky
 * @Description //TODO 
 * @Date 2023/5/12 15:54
 * @Param 
 * @return 
 **/ 
public class AmazonProfile implements Profile {

    @JSONField(name = "user_id")
    private String userId;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "email")
    private String email;

    @Override
    public String getOpenID() {
        return userId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAvatar() {
        return null;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
