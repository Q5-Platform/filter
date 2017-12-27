package com.codingapi.filter.zuul.helper;

/**
 *
 *
 * create by lorne on 2017/12/27
 */

public interface FilterZuulCheckHelper {


    /**
     * 是否需要对该请求的token数据检查
     * @param url 请求地址
     * @return true 需求，false 不需要
     */
    boolean needUrlTokenCheck(String url);


    /**
     * 是否需要对该请求检查
     * @param url   请求地址
     * @return  true 需要，false 不需要
     */
    boolean needUrlVerifyCheck(String url);


}
