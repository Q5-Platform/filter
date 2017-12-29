package com.codingapi.filter.core.exception;

import com.codingapi.filter.core.code.ProtocolState;

/**
 * 业务异常
 * 40000-50000之间
 * create by lorne on 2017/12/29
 */
public class OperationException extends FilterException{

    public OperationException(String protocolKey) {
        super(protocolKey);
    }

    public OperationException(String message, String protocolKey) {
        super(message, protocolKey);
    }

    public OperationException(String message, Throwable cause, String protocolKey) {
        super(message, cause, protocolKey);
    }

    public OperationException(Throwable cause, String protocolKey) {
        super(cause, protocolKey);
    }

    @Override
    protected void initCode(){
        this.code =  ProtocolState.getInstance().getCode(protocolKey);
        if(!(code>40000&&code<50000)){
            throw new RuntimeException("can't create the exception of key ->"+ protocolKey);
        }
    }

}
