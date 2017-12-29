package com.codingapi.filter.core;

import com.codingapi.filter.core.interceptor.handler.FilterDataResponseHandler;
import com.codingapi.filter.core.interceptor.handler.FilterExceptionHandler;
import com.codingapi.filter.core.interceptor.handler.FilterPreResponseHandler;
import com.codingapi.filter.core.interceptor.handler.def.DefFilterDataResponseHandler;
import com.codingapi.filter.core.interceptor.handler.def.DefFilterExceptionHandler;
import com.codingapi.filter.core.interceptor.handler.def.DefFilterPreResponseHandler;
import org.springframework.context.annotation.Bean;

/**
 * create by lorne on 2017/12/27
 */

public class DefFilterHandlerConfiguration {


    @Bean
    public FilterExceptionHandler filterExceptionHandler(){
        return new DefFilterExceptionHandler();
    }

    @Bean
    public FilterPreResponseHandler filterPreResponseHandler(){
        return new DefFilterPreResponseHandler();
    }

    @Bean
    public FilterDataResponseHandler filterDataResponseHandler(){
        return new DefFilterDataResponseHandler();
    }

}
