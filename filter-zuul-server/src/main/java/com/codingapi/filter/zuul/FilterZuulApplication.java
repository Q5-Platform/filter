package com.codingapi.filter.zuul;

import com.codingapi.filter.core.DefFilterHandlerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

/**
 * Created by lorne on 2017/7/8.
 */

@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableFeignClients
@Import(DefFilterHandlerConfiguration.class)
public class FilterZuulApplication {




    public static void main(String[] args) {
        SpringApplication.run(FilterZuulApplication.class, args);
    }

}
