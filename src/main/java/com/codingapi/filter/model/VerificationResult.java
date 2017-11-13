package com.codingapi.filter.model;

/**
 * Created by lorne on 2017/7/8.
 */
public class VerificationResult {


    public final static int STATE_ERROR = 0;

    public final static int STATE_OK = 1;

    public final static int STATE_METHOD_ERROR = 2;

    public final static int STATE_SIGN_NULL = 3;

    public final static int STATE_SIGN_ERROR = 4;

    public final static int STATE_TOKEN_ERROR = 5;

    public final static int STATE_TOKEN_NULL = 6;

    public VerificationResult() {
        state = STATE_OK;
    }

    private int state;

    private String msg;


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
