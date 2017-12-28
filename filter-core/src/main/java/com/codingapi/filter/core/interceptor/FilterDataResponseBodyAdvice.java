package com.codingapi.filter.core.interceptor;

import com.codingapi.filter.core.Constants;
import com.codingapi.filter.core.annotation.FilterResponse;
import com.codingapi.filter.core.interceptor.handler.FilterDataResponseHandler;
import com.codingapi.filter.core.interceptor.handler.FilterPreResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * create by lorne on 2017/12/27
 */
@ControllerAdvice
public class FilterDataResponseBodyAdvice implements ResponseBodyAdvice{

    private static Logger logger = LoggerFactory.getLogger(FilterDataResponseBodyAdvice.class);


    @Autowired
    private ApplicationContext applicationContext;

    private FilterDataResponseHandler filterDataResponseHandler;

    public boolean supports(MethodParameter returnType, Class converterType) {

        if(filterDataResponseHandler==null) {
            try {
                filterDataResponseHandler = applicationContext.getBean(FilterDataResponseHandler.class);
            } catch (Exception e) {
                filterDataResponseHandler = new FilterDataResponseHandler() {
                    public boolean supports(MethodParameter returnType, Class converterType) {
                        return false;
                    }

                    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
                        return null;
                    }
                };
            }
        }


        if(Constants.openInterceptor) {
            return true;
        }
        if(filterDataResponseHandler!=null){
            return filterDataResponseHandler.supports(returnType, converterType);
        }
        return false;
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Class converterType = returnType.getMethod().getDeclaringClass();
        FilterResponse defaultResponse = returnType.getMethod().getAnnotation(FilterResponse.class);
        if(defaultResponse==null) {
            defaultResponse = (FilterResponse) converterType.getAnnotation(FilterResponse.class);
        }
        String className =converterType.getName();
        logger.debug("beforeBodyWrite - className >" +className +", defaultResponse - > "+defaultResponse);
        if(defaultResponse!=null){
            switch (defaultResponse.type()){
                 case defaultFilter:{
                     response.getHeaders().add(Constants.defaultResponseHeader,Constants.defaultResponseHeader);
                }
            }
        }

        if(filterDataResponseHandler!=null){
            return filterDataResponseHandler.beforeBodyWrite(body, returnType, selectedContentType, selectedConverterType, request, response);
        }

        return body;
    }

}
