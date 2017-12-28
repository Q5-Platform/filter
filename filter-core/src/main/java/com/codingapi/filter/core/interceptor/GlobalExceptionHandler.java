package com.codingapi.filter.core.interceptor;

import com.codingapi.filter.core.Constants;
import com.codingapi.filter.core.model.ExcepModel;
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
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(value = Exception.class)
    public void  exceptionHandler(HttpServletRequest request, HttpServletResponse response,
                                  Object handler, Exception e) throws Exception {
        if(Constants.openInterceptor) {

            logger.debug("getAttribute -> " + request.getAttribute(Constants.defaultResponseHeader));
            if (Constants.defaultResponseHeader.equals(request.getAttribute(Constants.defaultResponseHeader))) {
                response.setHeader(Constants.defaultResponseHeader, Constants.defaultResponseHeader);
            } else {
                logger.debug(e.getMessage());
                String localizedMessage = e.getLocalizedMessage();
                String msg = e.getMessage();
                String className = e.getClass().getName();
                ExcepModel excepModel = new ExcepModel(localizedMessage, msg, className);
                response.setHeader(Constants.exceptionHeader, excepModel.toJsonString());
            }
            logger.debug("exceptionHandler->" + e + ",handler->" + handler);

            throw e;
        }
    }




}
