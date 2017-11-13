package com.codingapi.service;

import com.codingapi.model.VerificationResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lorne on 2017/7/8.
 */
public interface RequestVerificationService {

    VerificationResult execute(HttpServletRequest request, String url);

}
