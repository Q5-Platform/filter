package com.codingapi.filter.token.service.impl;

import com.codingapi.filter.core.token.TokenService;
import com.codingapi.filter.token.service.RedisServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by lorne on 2017/12/28
 */
@Service
public class TokenServiceImpl implements TokenService{

    @Autowired
    private RedisServerService redisServerService;

    public boolean putToken(String key, String value, int seconds) {
        redisServerService.putVal(key, value, seconds);
        return true;
    }

    public String getToken(String key) {
        return redisServerService.getVal(key);
    }
}
