package com.pirate.form.basketball;

import com.pirate.form.basketball.util.RedisOperator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redisOperator;

    @Test
    public void redisTest() throws Exception {
        String key = "无敌海贼";
        String value = "黑胡子";
        strRedis.opsForValue().set(key, value);
        System.out.println(strRedis.opsForValue().get(key));
        redisOperator.expireSeconds(key, 5);
    }
}
