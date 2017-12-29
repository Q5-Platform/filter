package com.demo.filter.controller;

import com.demo.filter.model.Demo;
import com.demo.filter.mq.DemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by lorne on 2017/12/27
 */
@RestController
@RequestMapping("/demo")
public class DemoController {


    @Autowired
    private DemoClient demoClient;

    @RequestMapping("/hello")
    public Demo hello() {

        Demo demo = new Demo();
        demo.setName(demoClient.hello());
        return demo;

    }
}
