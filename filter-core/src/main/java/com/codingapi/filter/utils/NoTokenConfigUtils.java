package com.codingapi.filter.utils;

import com.lorne.core.framework.utils.config.ConfigUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by houcunlu on 2017/7/25.
 */
public class NoTokenConfigUtils {

    private  static  List<String>  noToken = null;


    private NoTokenConfigUtils(){

    }

    static {

        noToken = new ArrayList<>();
        String [] notoken  =  ConfigUtils.getStringArrayValue("NoToken.properties","NoToken");
        noToken = Arrays.asList(notoken);

    }



    public static List<String> getNoToken() {
        return noToken;
    }



}
