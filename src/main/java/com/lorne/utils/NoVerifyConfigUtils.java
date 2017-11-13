package com.lorne.utils;

import com.lorne.core.framework.utils.config.ConfigUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by houcunlu on 2017/8/2.
 */
public class NoVerifyConfigUtils {


    /**
     *  第三方应用的回掉地址  无需任何验证的 直接转发的
     */
    private  static List<String> arrayList = null;

    private NoVerifyConfigUtils(){

    }

    static {

        arrayList = new ArrayList<>();
        String [] noVerify  =  ConfigUtils.getStringArrayValue("NoVerify.properties","NoVerify");
        arrayList = Arrays.asList(noVerify);


    }


    public static List<String> getNoVerify() {
        return arrayList;
    }


}
