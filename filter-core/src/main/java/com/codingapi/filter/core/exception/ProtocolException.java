package com.codingapi.filter.core.exception;

import com.codingapi.filter.core.code.ProtocolState;

/**
 * 协议异常
 * 30000-40000之间
 * create by lorne on 2017/12/29
 */
public class ProtocolException extends FilterException{



    @Override
    protected void initCode(){
        this.code =  ProtocolState.getInstance().getCode(protocolKey);
        if(!(code>30000&&code<40000)){
            throw new RuntimeException("can't create the exception of key ->"+ protocolKey);
        }
    }

    public ProtocolException(String protocolKey) {
        super(protocolKey);
    }

    public ProtocolException(String message, String protocolKey) {
        super(message, protocolKey);
    }

    public ProtocolException(String message, Throwable cause, String protocolKey) {
        super(message, cause, protocolKey);
    }

    public ProtocolException(Throwable cause, String protocolKey) {
        super(cause, protocolKey);
    }
}
