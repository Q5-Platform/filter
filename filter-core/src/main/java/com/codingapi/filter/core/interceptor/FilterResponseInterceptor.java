package com.codingapi.filter.core.interceptor;

import com.codingapi.filter.core.interceptor.handler.FilterPreResponseHandler;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lorne on 2017/8/16.
 */

public class FilterResponseInterceptor implements HandlerInterceptor {

    private FilterPreResponseHandler filterResponseHandler;

    public FilterResponseInterceptor(FilterPreResponseHandler filterResponseHandler) {
        this.filterResponseHandler = filterResponseHandler;
    }

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        return filterResponseHandler.preHandle(request, response, handler);
    }


    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        filterResponseHandler.postHandle(request, response, handler, modelAndView);
    }


    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        filterResponseHandler.afterCompletion(request, response, handler, ex);

    }


}
