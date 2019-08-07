package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：PostAcctChangeInfoDto
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-6
 * 编写时间                : 11:00
 * 程序功能（类）描述       ：向停车场推送车辆绑定或账户充值信息的请求参数
 */
public class PostAcctChangeInfoDto {
    @ApiModelProperty(value = "停车平台编号",required = true)
    private  String companyCode;
    @ApiModelProperty(value = "停车场编号",required = true)
    private  String code;
    @ApiModelProperty(value = "车牌号码",required = true)
    private  String plate;
    @ApiModelProperty(value = "车牌颜色 0-蓝 1-黄 2-白 3-黑,默认0")
    private  Integer plateColor=0;
    @ApiModelProperty(value = "停车记录流水号",required = true)
    private  String recordId;
    @ApiModelProperty(value = "入场时间（格式：yyyyMM-ddHHmmss）",required = true)
    private  String inTime	;
    @ApiModelProperty(value = "减免金额(0代表无减免)")
    private  Integer deduction;
    @ApiModelProperty(value = "优惠折扣(0代表无折扣)")
    private  Float discount;
    @ApiModelProperty(value = "用户动作 1-充值 2-绑定")
    private  Integer userAction;
    @ApiModelProperty(value = "余额")
    private  Integer balance;

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

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public Integer getDeduction() {
        return deduction;
    }

    public void setDeduction(Integer deduction) {
        this.deduction = deduction;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getUserAction() {
        return userAction;
    }

    public void setUserAction(Integer userAction) {
        this.userAction = userAction;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
