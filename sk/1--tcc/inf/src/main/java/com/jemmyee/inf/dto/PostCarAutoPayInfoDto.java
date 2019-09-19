package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：PostCarAutoPayInfoDto
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-14
 * 编写时间                : 03:00
 * 程序功能（类）描述       ：<p>
 */
public class PostCarAutoPayInfoDto {
    @ApiModelProperty(value = "停车记录流水号", required = true)
    private String recordId;
    @ApiModelProperty(value = "停车平台编号", required = true)
    private String companyCode;
    @ApiModelProperty(value = "停车场编号", required = true)
    private String  code;
    @ApiModelProperty(value = "车牌号码", required = true)
    private String plate;
    @ApiModelProperty(value = "车牌颜色 0-蓝 1-黄 2-白 3-黑,默认0")
    private Integer plateColor=0;
    @ApiModelProperty(value = "入场时间（格式：yyyyMM-ddHHmmss）", required = true)
    private  String inTime;
    @ApiModelProperty(value = "支付停车平台编号")
    private String	payedCompanyCode;
    @ApiModelProperty(value = "武汉停车会员号")
    private  String	userId;
    @ApiModelProperty(value = "自动扣费状态 0-可自动扣费 1-有欠费 2-不可扣费，默认2")
    private Integer	status=2;
    @ApiModelProperty(value = "余额（分）", required = true)
    private Integer	balance;
    @ApiModelProperty(value = "车辆是否欠费  0-否 1-是")
    private Integer	isCarArrear;
    @ApiModelProperty(value = "车辆欠费金额")
    private Integer carArrearAmount;
    @ApiModelProperty(value = "账户是否欠费 0-否 1-是")
    private Integer isAcctArrear;
    @ApiModelProperty(value = "账户欠费金额")
    private  Integer acctArrearAmount;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getPayedCompanyCode() {
        return payedCompanyCode;
    }

    public void setPayedCompanyCode(String payedCompanyCode) {
        this.payedCompanyCode = payedCompanyCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Integer getIsCarArrear() {
        return isCarArrear;
    }

    public void setIsCarArrear(Integer isCarArrear) {
        this.isCarArrear = isCarArrear;
    }

    public Integer getCarArrearAmount() {
        return carArrearAmount;
    }

    public void setCarArrearAmount(Integer carArrearAmount) {
        this.carArrearAmount = carArrearAmount;
    }

    public Integer getIsAcctArrear() {
        return isAcctArrear;
    }

    public void setIsAcctArrear(Integer isAcctArrear) {
        this.isAcctArrear = isAcctArrear;
    }

    public Integer getAcctArrearAmount() {
        return acctArrearAmount;
    }

    public void setAcctArrearAmount(Integer acctArrearAmount) {
        this.acctArrearAmount = acctArrearAmount;
    }
}
