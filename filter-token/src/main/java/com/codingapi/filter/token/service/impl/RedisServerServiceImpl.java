package com.codingapi.filter.token.service.impl;

import com.codingapi.filter.token.service.RedisServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * create by lorne on 2017/12/28
 */
@Service
public class RedisServerServiceImpl implements RedisServerService{


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void putVal(String key, String value, int seconds) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value, seconds, TimeUnit.SECONDS);

    }

    public String getVal(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }
}
