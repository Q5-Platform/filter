package com.codingapi.filter.zuul.handler.self;

import com.codingapi.filter.core.Constants;
import com.codingapi.filter.core.interceptor.handler.FilterExceptionHandler;
import com.codingapi.filter.zuul.model.Msg;
import com.codingapi.filter.zuul.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lorne on 2017/8/17.
 */

public class SelfZuulFilterExceptionHandler implements FilterExceptionHandler{

    private static Logger logger = LoggerFactory.getLogger(SelfZuulFilterExceptionHandler.class);


    @ExceptionHandler(value = Exception.class)
    public void  exceptionHandler(HttpServletRequest request, HttpServletResponse response,
                                  Object handler, Exception e) throws Exception {

        logger.debug("getAttribute -> " + request.getAttribute(Constants.defaultResponseHeader));

        if (Constants.defaultResponseHeader.equals(request.getAttribute(Constants.defaultResponseHeader))) {
            throw e;
        } else {
            logger.debug("exceptionHandler->" + e + ",handler->" + handler);

            Response res = new Response();
            Msg msg = new Msg();

            res.setCode(40010);
            res.setMsg(e.getLocalizedMessage());
            res.setData(e.getMessage());
            msg.setMsg("业务模块异常");

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
