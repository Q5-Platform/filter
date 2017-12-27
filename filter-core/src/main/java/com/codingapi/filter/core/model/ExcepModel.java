package com.codingapi.filter.core.model;

/**
 * create by lorne on 2017/12/27
 */
public class ExcepModel {


    private String localizedMessage;

    private String msg;

    private String className;

    public ExcepModel() {
    }

    public String toJsonString(){
        return String.format("{\"msg\":\"%s\",\"localizedMessage\":\"%s\",\"className\":\"%s\"}",msg,localizedMessage,className);
    }

    public ExcepModel(String localizedMessage, String msg, String className) {
        this.localizedMessage = localizedMessage;
        this.msg = msg;
        this.className = className;
    }


    public String getLocalizedMessage() {
        return localizedMessage;
    }

    public void setLocalizedMessage(String localizedMessage) {
        this.localizedMessage = localizedMessage;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
