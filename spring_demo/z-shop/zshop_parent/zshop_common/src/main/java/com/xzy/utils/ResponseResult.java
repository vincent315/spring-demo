package com.xzy.utils;

import com.xzy.constant.ResponseStatusConstant;

public class ResponseResult {
    //相应状态吗
    private int status;
    //相应消息
    private String message;
    //相应数据
    private Object data;

    public int getStatus() {
        return status;
    }
    public ResponseResult(){

    }
    public ResponseResult(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    //成功的静态方法
    public static ResponseResult success(Object data){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS, "success", data);
    }
    //失败的静态方法
    public static ResponseResult failed(String message){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_FAIL,message,null);
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
