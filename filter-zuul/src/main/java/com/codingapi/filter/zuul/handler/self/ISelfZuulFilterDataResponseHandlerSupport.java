package com.codingapi.filter.zuul.handler.self;

import org.springframework.core.MethodParameter;

/**
 * create by lorne on 2018/2/8
 */
public interface ISelfZuulFilterDataResponseHandlerSupport {

    boolean supports(MethodParameter returnType, Class converterType);
}
