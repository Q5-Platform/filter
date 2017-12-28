package com.codingapi.filter.core.interceptor.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by lorne on 2017/12/28
 */
public interface FilterExceptionHandler {

    void  exceptionHandler(HttpServletRequest request, HttpServletResponse response,
                           Object handler, Exception e) throws Exception;
}
