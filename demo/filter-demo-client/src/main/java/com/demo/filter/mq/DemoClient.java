package com.demo.filter.mq;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by lorne on 2017/12/28
 */
@FeignClient(value = "demo-server",fallback = DemoClientFallBack.class)
public interface DemoClient {


    @RequestMapping("demo/hello")
    String hello();


}
