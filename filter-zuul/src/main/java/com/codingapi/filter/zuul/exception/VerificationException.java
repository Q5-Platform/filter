package com.codingapi.filter.zuul.exception;

import com.codingapi.filter.zuul.em.VerificationState;
import com.lorne.core.framework.exception.ServiceException;

/**
 * create by lorne on 2017/12/27
 */
public class VerificationException extends ServiceException{

    private VerificationState verificationState;

    public VerificationException(VerificationState verificationState) {
        this.verificationState = verificationState;
    }

    public VerificationState getVerificationState() {
        return verificationState;
    }
}
