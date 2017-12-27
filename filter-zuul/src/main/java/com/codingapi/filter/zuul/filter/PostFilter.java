package com.codingapi.filter.zuul.filter;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.filter.core.Constants;
import com.codingapi.filter.core.model.ExcepModel;
import com.codingapi.filter.zuul.model.Msg;
import com.codingapi.filter.zuul.model.Response;
import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by lorne on 2017/7/26.
 */
public class PostFilter extends ZuulFilter {


    private final static String charsetName = "utf-8";

    private static Logger logger = LoggerFactory.getLogger(PostFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();

        List<Pair<String, String>> pairs =  ctx.getOriginResponseHeaders();
        String excpMsg = null;

        //返回默认数据的拦截处理
        for(Pair<String,String> pair:pairs){
            if(Constants.defaultResponseHeader.equals(pair.first())&&Constants.defaultResponseHeader.equals(pair.second())){
                logger.debug("response - defaultResponse->"+pairs);
                return null;
            }
            if(Constants.exceptionHeader.equals(pair.first())){
                excpMsg = pair.second();
            }
        }

        HttpServletResponse response =  ctx.getResponse();

        Response res = new Response();
        Msg msg = new Msg();

        try {

            if(response.getStatus() != 200) {
                response.setStatus(200);

                if(StringUtils.isNotEmpty(excpMsg)){
                    res.setCode(40010);
                    ExcepModel excepModel =  JSONObject.parseObject(excpMsg,ExcepModel.class);
                    res.setMsg(excepModel.getLocalizedMessage());
                    res.setData(excepModel);
                    msg.setMsg("业务模块异常");

                }else{
                    res.setCode(40020);
                    res.setMsg("获取异常失败");
                }

            }else{

                Object jsonObject = null;
                InputStream inputStream =  ctx.getResponseDataStream();
                if(inputStream!=null) {
                    String resString = IOUtils.toString(inputStream, charsetName);
                    try {
                        jsonObject = JSONObject.parseObject(resString);
                    } catch (Exception e) {
                        jsonObject = resString;
                    }
                }

                res.setCode(40000);
                res.setData(jsonObject);
                res.setMsg("");
            }
        } catch (IOException e) {
            res.setCode(40030);
            res.setMsg(e.getMessage());

        }

        msg.setState(1);
        msg.setRes(res);
        ctx.setResponseBody(msg.toJsonString());
        return null;
    }


}

