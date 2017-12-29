package com.demo.filter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by lorne on 2017/12/27
 */
@RestController
@RequestMapping("/demo")
public class DemoServerController {



    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello---->");
        return "hello";
    }
}
