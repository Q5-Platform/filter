package com.codingapi.filter.zuul.handler.self;

import com.codingapi.filter.core.annotation.FilterResponse;
import com.codingapi.filter.core.interceptor.handler.FilterDataResponseHandler;
import com.codingapi.filter.zuul.model.Msg;
import com.codingapi.filter.zuul.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

/**
 * create by lorne on 2017/12/27
 */

public class SelfZuulFilterDataResponseHandler implements FilterDataResponseHandler{

    private static Logger logger = LoggerFactory.getLogger(SelfZuulFilterDataResponseHandler.class);

    private ISelfZuulFilterDataResponseHandlerSupport selfZuulFilterDataResponseHandlerSupport;

    @Autowired
    private ApplicationContext spring;

    public boolean supports(MethodParameter returnType, Class converterType) {

        if(selfZuulFilterDataResponseHandlerSupport==null) {
            try {
                selfZuulFilterDataResponseHandlerSupport = spring.getBean(ISelfZuulFilterDataResponseHandlerSupport.class);
            } catch (Exception e) {
                selfZuulFilterDataResponseHandlerSupport = new ISelfZuulFilterDataResponseHandlerSupport() {
                    @Override
                    public boolean supports(MethodParameter returnType, Class converterType) {
                        return true;
                    }
                };
            }
        }

        return selfZuulFilterDataResponseHandlerSupport.supports(returnType, converterType);
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

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
                    return body;
                }
            }
        }

        Response res = new Response();
        Msg msg = new Msg();
        res.setCode(40000);
        res.setData(body);
        res.setMsg("");

        msg.setState(1);
        msg.setRes(res);

        return msg;
    }

}
