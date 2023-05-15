package com.skyworth.oltu.oauth2.profile;

import com.alibaba.fastjson.annotation.JSONField;
import com.skyworth.oltu.oauth2.Profile;

/**
 * @Author: sky-wushr
 * @Description:
 * @CREATE_TIME: 2018/9/5 14:20
 * @Modified By:
 */
public class AndroidLoginGoogleProfile implements Profile {

    @JSONField(name = "sub")
    private String userId;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "picture")
    private String picture;

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
        return picture;
    }

    @Override
    public String getEmail() {
        return null;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
