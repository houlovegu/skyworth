package com.skyworth.oauth.model;

public class OauthState {

    private String uid;

    private Status status;

    public static enum Status {
        Create("创建"),
        Timeout("超时"),
        Fail("失败"),
        Success("成功");

        Status(String desc) {
            this.desc = desc;
        }

        String desc;

        public String getDesc() {
            return desc;
        }
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
