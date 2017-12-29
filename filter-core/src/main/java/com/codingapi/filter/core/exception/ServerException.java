package com.codingapi.filter.core.exception;

import com.codingapi.filter.core.code.ProtocolState;

/**
 * 服务异常
 * 50000-60000之间
 * create by lorne on 2017/12/29
 */
public class ServerException extends FilterException{

    @Override
    protected void initCode(){
        this.code =  ProtocolState.getInstance().getCode(protocolKey);
        if(!(code>50000&&code<60000)){
            throw new RuntimeException("can't create the exception of key ->"+ protocolKey);
        }
    }

    public ServerException(String protocolKey) {
        super(protocolKey);
    }

    public ServerException(String message, String protocolKey) {
        super(message, protocolKey);
    }

    public ServerException(String message, Throwable cause, String protocolKey) {
        super(message, cause, protocolKey);
    }

    public ServerException(Throwable cause, String protocolKey) {
        super(cause, protocolKey);
    }
}
