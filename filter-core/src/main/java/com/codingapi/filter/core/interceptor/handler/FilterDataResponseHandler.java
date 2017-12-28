package com.codingapi.filter.core.interceptor.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

/**
 * create by lorne on 2017/12/28
 */
public interface FilterDataResponseHandler {

    boolean supports(MethodParameter returnType, Class converterType);

    Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response);


}
