package com.codingapi.filter.token.controller;

import com.codingapi.filter.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by lorne on 2017/12/28
 */
@RestController
@RequestMapping("/token")
public class TokenController {


    @Autowired
    private TokenService tokenService;

    @RequestMapping("/putToken")
    public boolean putToken(@RequestParam("key")String key, @RequestParam("value") String value, @RequestParam("seconds") int seconds){
        return tokenService.putToken(key,value,seconds);
    }

    @RequestMapping("/getToken")
    public String getToken(@RequestParam("key") String key){
        return tokenService.getToken(key);
    }
}
