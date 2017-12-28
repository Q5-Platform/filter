package com.demo.filter.helper;

import com.codingapi.filter.zuul.helper.FilterZuulCheckHelper;
import org.springframework.stereotype.Service;

/**
 * create by lorne on 2017/12/27
 */
@Service
public class MyFilterZuulCheckHelper implements FilterZuulCheckHelper{

    @Override
    public boolean needUrlTokenCheck(String url) {
        return false;
    }

    @Override
    public boolean needUrlVerifyCheck(String url) {
        return false;
    }
}
