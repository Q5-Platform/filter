package com.codingapi.filter.service;

import com.codingapi.filter.model.VerificationResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lorne on 2017/7/8.
 */
public interface RequestVerificationService {

    VerificationResult execute(HttpServletRequest request, String url);

}
