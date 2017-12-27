package com.demo.filter.controller;

import com.codingapi.filter.core.annotation.FilterResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by lorne on 2017/12/27
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/hello")
    @FilterResponse
    public String hello(){
        return "hello";
    }
}
