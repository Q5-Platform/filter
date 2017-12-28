package com.codingapi.filter.zuul;

import com.codingapi.filter.core.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import javax.annotation.PostConstruct;

/**
 * Created by lorne on 2017/7/8.
 */

@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableFeignClients
public class FilterZuulApplication {


    @PostConstruct
    public void init(){
        //开启事务拦截
        Constants.openInterceptor = true;
    }


    public static void main(String[] args) {
        SpringApplication.run(FilterZuulApplication.class, args);
    }

}
