package com.codingapi.filter.zuul.service;


import com.codingapi.filter.zuul.exception.VerificationException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lorne on 2017/7/8.
 */
public interface PreRequestVerificationService {

    void execute(HttpServletRequest request, String url) throws VerificationException;

}
