package com.demo.filter;

//import com.codingapi.filter.zuul.handler.FilterHandlerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * Created by lorne on 2017/7/8.
 */


@SpringBootApplication
@EnableDiscoveryClient
//@Import({ FilterHandlerConfiguration.class})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
