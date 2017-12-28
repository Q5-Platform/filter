package com.codingapi.filter.core.interceptor;

import com.codingapi.filter.core.Constants;
import com.codingapi.filter.core.interceptor.handler.FilterExceptionHandler;
import com.codingapi.filter.core.interceptor.handler.def.DefFilterExceptionHandler;
import com.codingapi.filter.core.model.ExcepModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lorne on 2017/8/17.
 */
@ControllerAdvice
public class FilterGlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(FilterGlobalExceptionHandler.class);


    @Autowired
    private ApplicationContext applicationContext;

    private FilterExceptionHandler filterExceptionHandler;

    @ExceptionHandler(value = Exception.class)
    public void  exceptionHandler(HttpServletRequest request, HttpServletResponse response,
                                  Object handler, Exception e) throws Exception {

        if(filterExceptionHandler==null) {
            try {
                filterExceptionHandler = applicationContext.getBean(FilterExceptionHandler.class);
            } catch (Exception ex) {
                filterExceptionHandler = new DefFilterExceptionHandler();
            }
        }

        filterExceptionHandler.exceptionHandler(request, response, handler, e);
    }




}
