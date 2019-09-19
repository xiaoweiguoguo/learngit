package com.jemmyee.core.web;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jemmyee@qq.com
 * @create 2017-03-15 15:35
 **/
public class Response<T> {

    @ApiModelProperty(value = "返回码")
    private String code;

    @ApiModelProperty(value = "返回信息")
    private String msg;

    @ApiModelProperty(value = "返回的对象数据")
    private T data;

    public Response() {

    }

    public Response(String code) {
        this.code = code;
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
