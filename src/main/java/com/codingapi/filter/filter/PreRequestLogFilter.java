package com.codingapi.filter.filter;

import com.codingapi.filter.model.VerificationResult;
import com.codingapi.filter.service.RequestVerificationService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lorne on 2017/7/8.
 */
public class PreRequestLogFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(PreRequestLogFilter.class);


//    private final static String ERROR_MSG_FORMAT = "{\"state\":0,\"res\":null,\"msg\":\"%s\"}";
    private final static String ERROR_MSG_FORMAT =  "{ \"res\": { \"code\": 40010 , \"msg\" : \"%s\"},\"state\": 1}";

    @Autowired
    private RequestVerificationService requestVerificationService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String fullUrl = request.getRequestURL().toString();
        String url = request.getRequestURI();

        logger.info(String.format("send %s request to %s", request.getMethod(),fullUrl));

        VerificationResult result =  requestVerificationService.execute(request,url);
        switch (result.getState()){
            case VerificationResult.STATE_OK:{
                ctx.setSendZuulResponse(true);
                ctx.setResponseStatusCode(200);
                return request;
            }
            default:{
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(200);
                ctx.setResponseBody(String.format(ERROR_MSG_FORMAT,result.getMsg()));
                return request;
            }
        }
    }


}
