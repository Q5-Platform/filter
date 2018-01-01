package com.codingapi.filter.core.interceptor.handler;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * create by lorne on 2018/1/1
 */
public interface FilterInterceptor {

    void addInterceptors(InterceptorRegistry registry);
}
