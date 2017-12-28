package com.codingapi.filter.token.service;

/**
 * create by lorne on 2017/12/28
 */
public interface RedisServerService {

    void putVal(String key,String value,int seconds);

    String getVal(String key);
}
