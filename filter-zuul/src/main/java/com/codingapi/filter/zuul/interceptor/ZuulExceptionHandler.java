package com.codingapi.filter.zuul.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lorne on 2017/8/17.
 */
@ControllerAdvice
public class ZuulExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(ZuulExceptionHandler.class);


    @ExceptionHandler(value = Exception.class)
    public void  exceptionHandler(HttpServletRequest request, HttpServletResponse response,
                                  Object handler, Exception e) throws Exception {


        logger.info("exceptionHandler->" + e + ",handler->" + handler);
    }




}
