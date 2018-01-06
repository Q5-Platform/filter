package com.codingapi.filter.zuul.model;


import com.alibaba.fastjson.JSONObject;

/**
 * Created by houcunlu on 2017/7/26.
 */
public class Msg {

    private int state;
    private String msg;
    private Response res;

    public Msg() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Msg(int state, Response res) {
        super();
        this.state = state;
        this.res = res;
    }

    public Msg(int state) {
        super();
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }


    public String toJsonString() {
        return JSONObject.toJSONString(this);
    }

}
