package com.codingapi.filter.core.interceptor;

import com.codingapi.filter.core.interceptor.handler.FilterDataResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private FilterDataResponseHandler filterDataResponseHandler;

    public boolean supports(MethodParameter returnType, Class converterType) {
        return filterDataResponseHandler.supports(returnType, converterType);
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return filterDataResponseHandler.beforeBodyWrite(body, returnType, selectedContentType, selectedConverterType, request, response);
    }

}
