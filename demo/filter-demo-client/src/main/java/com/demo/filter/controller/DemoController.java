package com.demo.filter.controller;

import com.demo.filter.model.Demo;
import com.demo.filter.mq.DemoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by lorne on 2017/12/27
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoClient demoClient;

    @RequestMapping("/hello")
    public Demo hello() {

        logger.info("hello");

        Demo demo = new Demo();
        demo.setName(demoClient.hello());

        logger.info("hello -end ");
        return demo;

    }
}
