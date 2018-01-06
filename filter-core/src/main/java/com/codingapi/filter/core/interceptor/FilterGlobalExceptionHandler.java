package com.codingapi.filter.core.interceptor;

import com.codingapi.filter.core.interceptor.handler.FilterExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lorne on 2017/8/17.
 */
@ControllerAdvice
public class FilterGlobalExceptionHandler {


    @Autowired
    private FilterExceptionHandler filterExceptionHandler;

    @ExceptionHandler(value = Exception.class)
    public void   exceptionHandler(HttpServletRequest request, HttpServletResponse response,
                                  Object handler, Exception e) throws Throwable {
        filterExceptionHandler.exceptionHandler(request, response, handler, e);
    }




}
