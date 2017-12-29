package com.codingapi.filter.core.exception;

import com.lorne.core.framework.exception.ServiceException;

/**
 * create by lorne on 2017/12/29
 */
public abstract class FilterException extends ServiceException {

    protected abstract void initCode();

    protected String protocolKey;
    protected int code;

    public String getProtocolKey() {
        return protocolKey;
    }

    public int getCode() {
        return code;
    }

    public FilterException(String protocolKey) {
        this.protocolKey = protocolKey;
        initCode();
    }

    public FilterException(String message, String protocolKey) {
        super(message);
        this.protocolKey = protocolKey;
        initCode();
    }

    public FilterException(String message, Throwable cause, String protocolKey) {
        super(message, cause);
        this.protocolKey = protocolKey;
        initCode();
    }

    public FilterException(Throwable cause, String protocolKey) {
        super(cause);
        this.protocolKey = protocolKey;
        initCode();
    }
}
