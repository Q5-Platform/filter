package com.codingapi.filter.em;

/**
 * Created by lorne on 2017/7/8.
 */
public enum VerificationState {

    STATE_ERROR(0),STATE_OK(1),STATE_METHOD_ERROR(2),STATE_SIGN_NULL(3),STATE_SIGN_ERROR(4),STATE_TOKEN_ERROR(5),STATE_TOKEN_NULL(6);


    private int code;

    VerificationState(int code) {
        this.code = code;
    }

     public  static VerificationState valueOfCode(int code){
         VerificationState[] verificationResults = VerificationState.values();
         for(VerificationState vr:verificationResults){
             if(vr.getCode() == code){
                 return vr;
             }
         }
         return null;
     }

    public int getCode() {
        return code;
    }


    @Override
    public String toString() {
        return super.toString();
    }


}
