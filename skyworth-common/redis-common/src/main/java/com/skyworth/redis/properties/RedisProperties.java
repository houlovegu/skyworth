package com.skyworth.redis.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RedisProperties
 * @Description TODO
 * @Author sky
 * @Date 2023/5/11 16:36
 * @Version 1.0
 **/
//@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private String host;

    private int port;

    private int database;

    private long timeout;

    private String password;

    private Lettuce lettuce;

//    public class Lettuce {
//        private long shutdownTimeout;
//
//        private Pool pool;
//
//        public long getShutdownTimeout() {
//            return shutdownTimeout;
//        }
//
//        public void setShutdownTimeout(long shutdownTimeout) {
//            this.shutdownTimeout = shutdownTimeout;
//        }
//
//        public Pool getPool() {
//            return pool;
//        }
//
//        public void setPool(Pool pool) {
//            this.pool = pool;
//        }
//
//        @Configuration
//        public class Pool{
//            private int maxIdle;
//
//            private int minIdle;
//
//            private int maxActive;
//
//            private long maxWait;
//
//            public int getMaxIdle() {
//                return maxIdle;
//            }
//
//            public void setMaxIdle(int maxIdle) {
//                this.maxIdle = maxIdle;
//            }
//
//            public int getMinIdle() {
//                return minIdle;
//            }
//
//            public void setMinIdle(int minIdle) {
//                this.minIdle = minIdle;
//            }
//
//            public int getMaxActive() {
//                return maxActive;
//            }
//
//            public void setMaxActive(int maxActive) {
//                this.maxActive = maxActive;
//            }
//
//            public long getMaxWait() {
//                return maxWait;
//            }
//
//            public void setMaxWait(long maxWait) {
//                this.maxWait = maxWait;
//            }
//        }
//    }



    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Lettuce getLettuce() {
        return lettuce;
    }

    public void setLettuce(Lettuce lettuce) {
        this.lettuce = lettuce;
    }
}
