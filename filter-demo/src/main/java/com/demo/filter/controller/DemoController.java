package com.demo.filter.controller;

import com.demo.filter.model.Demo;
import com.lorne.core.framework.exception.ServiceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by lorne on 2017/12/27
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/hello")
//    @FilterResponse
    public Demo hello() throws ServiceException{
        Demo demo = new Demo();
        demo.setName("hello");
        return demo;

//        return "hello";
    }
}
