package com.codingapi.filter.zuul.handler;

import com.codingapi.filter.core.interceptor.handler.FilterPreResponseHandler;
import com.codingapi.filter.zuul.exception.VerificationException;
import com.codingapi.filter.zuul.service.PreRequestVerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lorne on 2017/8/16.
 */

public class ZuulFilterPreResponseHandler implements FilterPreResponseHandler {

    @Autowired
    private PreRequestVerificationService requestVerificationService;

    private final static String ERROR_MSG_FORMAT =  "{ \"res\": { \"code\": 40010 , \"msg\" : \"%s\"},\"state\": 1}";


    private Logger logger = LoggerFactory.getLogger(ZuulFilterPreResponseHandler.class);

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)throws Exception {

        String fullUrl = request.getRequestURL().toString();
        String url = request.getRequestURI();


        logger.debug(String.format("send %s request to %s", request.getMethod(),fullUrl));
        try {
            requestVerificationService.execute(request,url);
            return true;
        } catch (VerificationException e) {
            logger.error(e.getMessage());

            response.setContentType("text/html;charset=utf-8");
            response.setHeader("Content-type",
                    "application/json;charset=utf-8");
            response.getWriter().print(String.format(ERROR_MSG_FORMAT,e.getVerificationState()));
            response.getWriter().close();
            return false;
        }

    }




    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {



    }


}
