package com.pirate.form.basketball.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 封装的redis操作工具
 */
@Component
public class RedisOperator {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public Boolean expireSeconds(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }
}
