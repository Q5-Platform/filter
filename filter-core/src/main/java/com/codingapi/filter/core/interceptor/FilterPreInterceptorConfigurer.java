package com.codingapi.filter.core.interceptor;

import com.codingapi.filter.core.interceptor.handler.FilterInterceptor;
import com.codingapi.filter.core.interceptor.handler.FilterPreResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lorne on 2017/8/16.
 */

@Configuration
public class FilterPreInterceptorConfigurer extends WebMvcConfigurerAdapter {


    @Autowired
    private FilterPreResponseHandler filterPreResponseHandler = null;

    @Autowired
    private ApplicationContext applicationContext;

    private FilterInterceptor filterInterceptor;

    private Logger logger  = LoggerFactory.getLogger(FilterPreInterceptorConfigurer.class);

    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration filterResponseInterceptor = registry.addInterceptor(new FilterResponseInterceptor(filterPreResponseHandler));
        // 拦截配置
        filterResponseInterceptor.addPathPatterns("/**");

        try {
            filterInterceptor =  applicationContext.getBean(FilterInterceptor.class);
        }catch (Exception e){
        }

        logger.info("filterInterceptor->"+filterInterceptor);

        if(filterInterceptor!=null){
            filterInterceptor.addInterceptors(registry);
        }

    }

}
