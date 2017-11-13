package com.codingapi.mq.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lorne on 2017/7/8.
 */

@FeignClient(value = "token")
public interface TokenService {

    @RequestMapping("/token/token/putToken")
    boolean putToken(@RequestParam("key")String key,@RequestParam("value") String value,@RequestParam("seconds") int seconds);

    @RequestMapping("/token/token/getToken")
    String getToken(@RequestParam("key") String key);

}
