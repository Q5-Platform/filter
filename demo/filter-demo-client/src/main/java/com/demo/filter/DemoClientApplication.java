package com.demo.filter;

import com.codingapi.filter.core.DefFilterHandlerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * Created by lorne on 2017/7/8.
 */


@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@Import(DefFilterHandlerConfiguration.class)
public class DemoClientApplication {



    public static void main(String[] args) {
        SpringApplication.run(DemoClientApplication.class, args);
    }

}
