package com.codingapi.filter.zuul;

import com.codingapi.filter.zuul.filter.PostFilter;
import com.codingapi.filter.zuul.filter.PreRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by lorne on 2017/12/27
 */

@Configuration
public class ZuulFilterConfig {

    @Bean
    public PreRequestFilter preRequestLogFilter() {
        return new PreRequestFilter();
    }


    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

}
