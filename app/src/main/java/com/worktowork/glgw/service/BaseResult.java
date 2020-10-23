package com.worktowork.glgw.service;

public class BaseResult<B>  {
    private String code;
    private String msg;
    private B data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public B getData() {
        return data;
    }

    public void setData(B data) {
        this.data = data;
    }
}
