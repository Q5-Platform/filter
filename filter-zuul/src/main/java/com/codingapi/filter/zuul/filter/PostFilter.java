package com.codingapi.filter.zuul.filter;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.filter.core.Constants;
import com.codingapi.filter.zuul.model.Msg;
import com.codingapi.filter.zuul.model.Response;
import com.lorne.core.framework.exception.ServiceException;
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
 * Created by houcunlu on 2017/7/26.
 */
public class PostFilter extends ZuulFilter {

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
        Msg msg = new Msg();
        Response res = new Response();
        RequestContext ctx = RequestContext.getCurrentContext();

        List<Pair<String, String>> pairs =  ctx.getOriginResponseHeaders();

        //返回默认数据的拦截处理
        for(Pair<String,String> pair:pairs){
            if(Constants.defaultResponseHeader.equals(pair.first())&&Constants.defaultResponseHeader.equals(pair.second())){
                logger.debug("response - defaultResponse->"+pairs);
                return null;
            }
        }

        HttpServletResponse response =  ctx.getResponse();

        InputStream  dataInput  = ctx.getResponseDataStream();

        if(response.getStatus() != 200){
            response.setStatus(200);
            // 异常
            if(dataInput != null){
                String data = null;
                String error  = "";
                try {
                    data = IOUtils.toString(dataInput,"UTF-8");
                } catch (IOException e) {
                    error = "服务器内部错误！";
                }
                JSONObject jb =  JSONObject.parseObject(data);
                Object exception =  jb.get("exception");
                if(ServiceException.class.getName().equals(exception)){
                    error = jb.getString("message");
                }else{
                    error = jb.getString("exception")+":"+jb.getString("message")+jb.getString("path") ;
                }

                res.setCode(40010);
                res.setMsg(error);
                msg.setState(1);
                msg.setRes(res);
                ctx.setResponseBody(msg.toJsonString());

            }else{
                msg.setRes(null);
                msg.setState(0);
            }

        }else{
            //正常
            if(dataInput != null){
                try {
                    String data =  IOUtils.toString(dataInput,"UTF-8");
                    Object object = "";
                    if(isJson(data)){
                        object = JSONObject.parse(data);
                    }else {
                        object = data;
                    }
                    res.setCode(40000);
                    res.setData(object);
                    res.setMsg("");
                    msg.setState(1);
                    msg.setRes(res);
                    ctx.setResponseBody(msg.toJsonString());
                } catch (IOException e) {
                    res.setMsg("数据转换错误！");
                    res.setCode(40010);
                    res.setData(null);
                    msg.setState(0);
                    msg.setRes(res);
                    ctx.setResponseBody(msg.toJsonString());
                }

            }
        }
        return null;
    }



    public static boolean isJson(String json) {
        if(!StringUtils.isEmpty(json)){
            try {
                JSONObject.parse(json);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return  false;
    }
}

