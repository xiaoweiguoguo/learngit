package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：PostTokenCodeDto
 * 编写者                  : LiHesherng
 * 编写日期                : 2017-10-20
 * 编写时间                : 14:25
 * 程序功能（类）描述       ：获取联盟token
 */
public class PostTokenCodeDto {

    @ApiModelProperty(value = "运营公司编号", required = true)
    private String account;
    @ApiModelProperty(value = "时间(20171020153300)", required = true)
    private String timestamp;
    @ApiModelProperty(value = "秘钥", required = true)
    private String signature;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
