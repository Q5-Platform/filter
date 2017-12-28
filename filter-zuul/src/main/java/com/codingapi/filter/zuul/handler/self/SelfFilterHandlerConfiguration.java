package com.codingapi.filter.zuul.handler.self;

import com.codingapi.filter.core.interceptor.handler.FilterDataResponseHandler;
import com.codingapi.filter.core.interceptor.handler.FilterExceptionHandler;
import com.codingapi.filter.core.interceptor.handler.FilterPreResponseHandler;
import org.springframework.context.annotation.Bean;

/**
 * 直接引用zuul作为项目使用时，需要在Application上启用该配置
 * @Import({ FilterHandlerConfiguration.class})
 * create by lorne on 2017/12/28
 */

public class SelfFilterHandlerConfiguration {

    @Bean
    public FilterExceptionHandler filterExceptionHandler(){
        return new SelfZuulFilterExceptionHandler();
    }

    @Bean
    public FilterPreResponseHandler filterPreResponseHandler(){
        return new SelfZuulFilterPreResponseHandler();
    }


    @Bean
    public FilterDataResponseHandler filterDataResponseHandler(){
        return new SelfZuulFilterDataResponseHandler();
    }
}
