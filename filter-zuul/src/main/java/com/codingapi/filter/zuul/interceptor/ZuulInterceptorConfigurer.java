package com.codingapi.filter.zuul.interceptor;

import com.codingapi.filter.core.interceptor.ExceptionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lorne on 2017/8/16.
 */

@Configuration
public class ZuulInterceptorConfigurer extends WebMvcConfigurerAdapter {



    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration exceptionInterceptor = registry.addInterceptor(new ZuulPreInterceptor());
        // 拦截配置
        exceptionInterceptor.addPathPatterns("/**");

    }

}
