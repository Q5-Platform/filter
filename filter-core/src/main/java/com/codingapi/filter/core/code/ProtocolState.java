package com.codingapi.filter.core.code;


/**
 * filter状态码范围说明：
 * 30000-40000 表示的是协议错误。其中 30000 标示无效请求，40000 标示正常响应。
 * 40001-49999 表示的业务正常异常。例如：用户名不能为空，年龄格式不合法。
 * 50001-60000 表示的服务器异常状态。例如：服务器挂机，服务器请求超时等异常信息。
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * create by lorne on 2017/12/29
 */
public final class ProtocolState {


    public static final String PROTOCOL_REFUSE_KEY = "PROTOCOL_REFUSE";//拒绝请求，通常代表的是无效token或者请求无效
    public static final int PROTOCOL_REFUSE_VAL = 30000;//拒绝请求，通常代表的是无效token或者请求无效

    public static final String PROTOCOL_SUCCESS_KEY = "PROTOCOL_SUCCESS";//协议正常
    public static final int PROTOCOL_SUCCESS_VAL = 40000;//协议正常

    private static ProtocolState filterState;

    public static ProtocolState getInstance() {
        if (filterState == null) {
            synchronized (ProtocolState.class) {
                if (filterState == null) {
                    filterState = new ProtocolState();
                }
            }
        }
        return filterState;
    }


    private Map<String, Integer> map;


    private ProtocolState() {
        map = new ConcurrentHashMap<String, Integer>();
        initCode();
    }


    private void initCode(){

        map.put(PROTOCOL_REFUSE_KEY,PROTOCOL_REFUSE_VAL);
        map.put(PROTOCOL_SUCCESS_KEY,PROTOCOL_SUCCESS_VAL);

    }


    public int getCode(String key){
        Integer code = map.get(key);
        if(code==null){
            throw new RuntimeException("key not exist . ->"+key);
        }
        return code.intValue();
    }



    public void addCode(String key,int code){
        if(code>40000&&code<50000){
            if(map.containsKey(key)){
               throw new RuntimeException("key has exist. - >"+key);
            }
            map.put(key,code);
        }
    }

    public void removeCode(String key){
        if(map.containsKey(key)){
            throw new RuntimeException("key has exist. - >"+key);
        }
        Integer val =  map.get(key);
        if(val.intValue()>40000&&val.intValue()<50000){
            map.remove(key);
        }

        throw new RuntimeException("not alown remove the val . - >"+key);
    }



    protected void addProtocolCode(String key,int code){
        if(code>30000&&code<40000){
            if(map.containsKey(key)){
                throw new RuntimeException("key has exist. - >"+key);
            }
            map.put(key,code);
        }
    }

    protected void addServerErrorCode(String key,int code){
        if(code>50000&&code<60000){
            if(map.containsKey(key)){
                throw new RuntimeException("key has exist. - >"+key);
            }
            map.put(key,code);
        }
    }

}
