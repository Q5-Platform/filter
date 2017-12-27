package com.demo.filter.interceptor;

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
public class DataResponseBodyAdvice implements ResponseBodyAdvice{


    private Logger logger = LoggerFactory.getLogger(DataResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {

        logger.info("supports->");

        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        logger.info("beforeBodyWrite->");

        return body;
    }
}
