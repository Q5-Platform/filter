package com.codingapi.filter.service;


import com.codingapi.filter.exception.VerificationException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lorne on 2017/7/8.
 */
public interface PreRequestVerificationService {

    void execute(HttpServletRequest request, String url) throws VerificationException;

}
