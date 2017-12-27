package com.codingapi.filter.exception;

import com.codingapi.filter.em.VerificationState;
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
