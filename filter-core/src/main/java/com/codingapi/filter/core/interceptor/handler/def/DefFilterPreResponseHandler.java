package com.codingapi.filter.core.interceptor.handler.def;

import com.codingapi.filter.core.Constants;
import com.codingapi.filter.core.annotation.FilterResponse;
import com.codingapi.filter.core.interceptor.handler.FilterPreResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lorne on 2017/8/16.
 */

public class DefFilterPreResponseHandler implements FilterPreResponseHandler {

    private Logger logger = LoggerFactory.getLogger(DefFilterPreResponseHandler.class);

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (handlerMethod != null) {
            if (handlerMethod.getMethod() != null) {

                FilterResponse filterResponse = handlerMethod.getMethod().getAnnotation(FilterResponse.class);
                if (filterResponse == null) {

                    filterResponse = handlerMethod.getMethod().getDeclaringClass().getAnnotation(FilterResponse.class);
                }

                logger.debug("filterResponse->" + filterResponse);

                if (filterResponse != null) {

                    switch (filterResponse.type()) {
                        case defaultFilter: {
                            request.setAttribute(Constants.defaultResponseHeader, Constants.defaultResponseHeader);
                        }
                    }
                }

            }
        }
        return true;

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
