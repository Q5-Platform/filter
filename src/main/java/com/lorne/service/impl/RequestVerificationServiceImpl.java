package com.lorne.service.impl;

import com.lorne.utils.NoTokenConfigUtils;
import com.lorne.utils.NoVerifyConfigUtils;
import com.lorne.model.VerificationResult;
import com.lorne.mq.rpc.TokenService;
import com.lorne.service.RequestVerificationService;
import com.lorne.core.framework.utils.encode.MD5Util;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * Created by lorne on 2017/7/8.
 */
@Service
public class RequestVerificationServiceImpl implements RequestVerificationService {

    private Logger logger = LoggerFactory.getLogger(RequestVerificationServiceImpl.class);

    @Autowired
    private TokenService tokenService;


    @Override
    public VerificationResult execute(HttpServletRequest request, String url) {

        VerificationResult verificationResult = new VerificationResult();
//
        //todo check url
        logger.info("url:"+url);

        // 不需要任何验证的地址 【第三方应用的回掉】

        List<String> list =  NoVerifyConfigUtils.getNoVerify();
        if(list.contains(url)){
            return  verificationResult;
        }

        //todo check post method
        String method = request.getMethod();
        logger.info("method:"+method);
        if(!"POST".equals(method)){
            verificationResult.setState(VerificationResult.STATE_METHOD_ERROR);
            verificationResult.setMsg("method error");
            return verificationResult;
        }


       //todo check token sign
        String sign = ServletRequestUtils.getStringParameter(request, "sign", "");
        String token = ServletRequestUtils.getStringParameter(request, "token", "");
        logger.info("sign:"+sign+",token:"+token);


//        if(StringUtils.isEmpty(sign)){
//            verificationResult.setState(VerificationResult.STATE_SIGN_NULL);
//            verificationResult.setMsg("sign is null");
//            return verificationResult;
//        }

        // 不需要Token 的地址
        List<String> noTokens =  NoTokenConfigUtils.getNoToken();

        if (!noTokens.contains(url)) {
            if(StringUtils.isNotEmpty(token)){
                String tokenValue = tokenService.getToken(token);
                if(StringUtils.isEmpty(tokenValue)){
                    verificationResult.setState(VerificationResult.STATE_TOKEN_ERROR);
                    verificationResult.setMsg("token no exist");
                    return verificationResult;
                }
            }else{
                verificationResult.setState(VerificationResult.STATE_TOKEN_ERROR);
                verificationResult.setMsg("token no exist!");
                return verificationResult;
            }
        }


        String json = "";
        try {
            json = IOUtils.toString(request.getInputStream(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String checkSign = "";
        try {
        if (StringUtils.isNotEmpty(token)) {
            checkSign = MD5Util.md5(("token="+token+"&content="+json).getBytes("utf-8"));
        } else {
            String vlaue = "content="+json;
            checkSign =  MD5Util.md5((vlaue).getBytes("utf-8"));
        }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        boolean checkSignOk = sign.equals(checkSign);
        logger.info("signOk:"+checkSignOk);
        if (!checkSignOk) {
            verificationResult.setState(VerificationResult.STATE_SIGN_ERROR);
            verificationResult.setMsg("sign error ");
            return verificationResult;
        }
        //todo check security
        return verificationResult;
    }


}
