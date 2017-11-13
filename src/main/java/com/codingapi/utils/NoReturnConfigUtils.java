package com.codingapi.utils;

import com.lorne.core.framework.utils.config.ConfigUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by houcunlu on 2017/8/4.
 */
public class NoReturnConfigUtils {

    /**
     *  无需任何数据封装的 地址
     */
    private  static List<String> NoReturn = null;


    static {

        NoReturn = new ArrayList<>();
        String [] noreturn  =  ConfigUtils.getStringArrayValue("NoReturn.properties","NoReturn");
        NoReturn = Arrays.asList(noreturn);

    }


    public static List<String> getNoReturn() {
        return NoReturn;
    }

}
