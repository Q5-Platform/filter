package com.codingapi.filter.zuul.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * create by lorne on 2017/12/27
 */
@ControllerAdvice
public class ZuulDataResponseBodyAdvice implements ResponseBodyAdvice{

    private static Logger logger = LoggerFactory.getLogger(ZuulDataResponseBodyAdvice.class);


    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        logger.info("beforeBodyWrite - className >");

        return body;
    }

}
