package com.jemmyee.inf.vo;

/**
 * Created by lenovo on 2017/9/7.
 */
public class ParkingFeeVo {
    //处理结果（0-成功 1-失败）
    private Integer status;

    //支付费用
    private Integer payFee;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayFee() {
        return payFee;
    }

    public void setPayFee(Integer payFee) {
        this.payFee = payFee;
    }
}
