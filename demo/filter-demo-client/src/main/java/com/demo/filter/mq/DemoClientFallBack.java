package com.demo.filter.mq;

import org.springframework.stereotype.Component;

/**
 * create by lorne on 2017/12/28
 */
@Component
public class DemoClientFallBack implements DemoClient{

    @Override
    public String hello() {
        System.out.println("xxxddxxxxxxxxxxxxxxxxxxxxxxxxxxxxd");
        throw new RuntimeException("xxxxxxx");
    }
}
