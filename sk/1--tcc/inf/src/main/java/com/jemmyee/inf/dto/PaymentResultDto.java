package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lenovo on 2017/9/6.
 */
public class PaymentResultDto {

    @ApiModelProperty(value = "扣费请求流水号（订单编号）",required = true)
    private String paymentId;

    @ApiModelProperty(value = "停车场编号",required = true)
    private String code;

    @ApiModelProperty(value = "联盟平台编号",required = true)
    private String platformCode;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }
}
