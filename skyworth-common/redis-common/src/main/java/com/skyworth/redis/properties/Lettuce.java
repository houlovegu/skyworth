package com.skyworth.redis.properties;

/**
 * @ClassName Lettuce
 * @Description TODO
 * @Author sky
 * @Date 2023/5/15 14:53
 * @Version 1.0
 **/
public class Lettuce {

    private long shutdownTimeout;

    private Pool pool;

    public long getShutdownTimeout() {
        return shutdownTimeout;
    }

    public void setShutdownTimeout(long shutdownTimeout) {
        this.shutdownTimeout = shutdownTimeout;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }
}
