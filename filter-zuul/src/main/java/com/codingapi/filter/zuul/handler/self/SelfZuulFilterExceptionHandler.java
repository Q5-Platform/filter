package com.codingapi.filter.zuul.handler.self;

import com.codingapi.filter.core.Constants;
import com.codingapi.filter.core.interceptor.handler.FilterExceptionHandler;
import com.codingapi.filter.zuul.model.Msg;
import com.codingapi.filter.zuul.model.Response;
import com.lorne.core.framework.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lorne on 2017/8/17.
 */

public class SelfZuulFilterExceptionHandler implements FilterExceptionHandler{

    private static Logger logger = LoggerFactory.getLogger(SelfZuulFilterExceptionHandler.class);


    public void  exceptionHandler(HttpServletRequest request, HttpServletResponse response,
                                  Object handler, Exception e) throws Throwable {

        e.printStackTrace();

        logger.debug("exceptionHandler->" + e + ",handler->" + handler);
        logger.debug("getAttribute -> " + request.getAttribute(Constants.defaultResponseHeader));

        if (Constants.defaultResponseHeader.equals(request.getAttribute(Constants.defaultResponseHeader))) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace(response.getWriter());
            response.getWriter().close();

        } else {
            Response res = new Response();
            Msg msg = new Msg();
            res.setCode(40010);
            msg.setMsg("");

            if(e instanceof ServiceException){
                ServiceException serviceException = (ServiceException) e;
                res.setMsg(serviceException.getMessage());
            }else{
                res.setMsg(e.getMessage());
            }

            msg.setState(1);
            msg.setRes(res);

            response.setContentType("text/html;charset=utf-8");
            response.setHeader("Content-type",
                    "application/json;charset=utf-8");
            response.getWriter().print(msg.toJsonString());
            response.getWriter().close();
        }
    }




}
