package com.lorne.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lorne.model.Msg;
import com.lorne.model.Response;
import com.lorne.utils.NoReturnConfigUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by houcunlu on 2017/7/26.
 */
public class PostFilter extends ZuulFilter {


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
        HttpServletResponse response =  ctx.getResponse();

        InputStream  dataInput  = ctx.getResponseDataStream();

        HttpServletRequest request = ctx.getRequest();
        String url = request.getRequestURI();


        List<String> NoReturn =  NoReturnConfigUtils.getNoReturn();
        if(NoReturn.contains(url)){
            return  null;
        }


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
                if("com.lorne.core.framework.exception.ServiceException".equals(exception)){
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
                    res.setCode(40000);
                    res.setData(data);
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
}

