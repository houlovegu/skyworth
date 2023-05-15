package com.skyworth.oltu.oauth2;

public interface Profile {

    /**
     * 获取openId
     *
     * @return
     */
    String getOpenID();

    /**
     * 用户名
     *
     * @return
     */
    String getName();

    /**
     * 头像
     *
     * @return
     */
    String getAvatar();


    /**
     * 邮箱
     *
     * @return
     */
    String getEmail();
}
