package com.codingapi.filter.token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * create by lorne on 2017/12/27
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
public class FilterTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterTokenApplication.class, args);
    }

}
