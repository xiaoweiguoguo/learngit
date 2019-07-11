package com.xnjg.response;

/**
 * ==========================
 * Created with IntelliJ IDEA.
 *
 * @Auth: weixw
 * @Date: 2019/4/24 11:58
 * @Version 1.0.0
 * ==========================
 */
public class ResponseData<T> {

    //返回码
    private String code;
    //返信息
    private String msg;
    //返数据
    private T data;

    public ResponseData() {

    }

    public ResponseData(String code) {
        this.code = code;
    }

    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
