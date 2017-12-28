package com.demo.filter;

import com.codingapi.filter.core.interceptor.handler.FilterDataResponseHandler;
import com.codingapi.filter.core.interceptor.handler.FilterExceptionHandler;
import com.codingapi.filter.core.interceptor.handler.FilterPreResponseHandler;
import com.codingapi.filter.zuul.handler.ZuulFilterDataResponseHandler;
import com.codingapi.filter.zuul.handler.ZuulFilterExceptionHandler;
import com.codingapi.filter.zuul.handler.ZuulFilterPreResponseHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by lorne on 2017/12/28
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterExceptionHandler filterExceptionHandler(){
        return new ZuulFilterExceptionHandler();
    }

    @Bean
    public FilterPreResponseHandler filterPreResponseHandler(){
        return new ZuulFilterPreResponseHandler();
    }


    @Bean
    public FilterDataResponseHandler filterDataResponseHandler(){
        return new ZuulFilterDataResponseHandler();
    }
}
