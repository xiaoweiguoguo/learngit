package com.jemmyee.inf.rv;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：ParkingWhetherFeeDeductionRv
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-8
 * 编写时间                : 02:46
 * 程序功能（类）描述       ：车辆进场后平台向联盟查询账户并提交入场信息（同三方）,联盟返回参数
 */
public class ParkingWhetherFeeDeductionRv {
    @ApiModelProperty(value = "状态返回 0-可自动扣费 1-有停车场欠费 2-不可扣费")
    private Integer	status;
    @ApiModelProperty(value = "余额")
    private Integer	balance;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
