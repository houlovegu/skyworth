package com.skyworth.redis.properties;

/**
 * @ClassName Pool
 * @Description TODO
 * @Author sky
 * @Date 2023/5/15 14:53
 * @Version 1.0
 **/
public class Pool {

    private int maxIdle;

    private int minIdle;

    private int maxActive;

    private long maxWait;

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public long getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(long maxWait) {
        this.maxWait = maxWait;
    }
}
