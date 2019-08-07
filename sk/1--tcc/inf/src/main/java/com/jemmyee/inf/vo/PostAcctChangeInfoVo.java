package com.jemmyee.inf.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：PostAcctChangeInfoVo
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-13
 * 编写时间                : 08:50
 * 程序功能（类）描述       ：<p>
 */
public class PostAcctChangeInfoVo {
    @ApiModelProperty(value = "停车平台编号",required = true)
    private  String companyCode;
    @ApiModelProperty(value = "停车场编号",required = true)
    private  String code;
    @ApiModelProperty(value = "车牌号码",required = true)
    private  String plate;
    @ApiModelProperty(value = "车牌颜色 0-蓝 1-黄 2-白 3-黑,默认0")
    private  Integer plateColor=0;
    @ApiModelProperty(value = "停车记录流水号",required = true)
    private  Integer recordId;
    @ApiModelProperty(value = "入场时间（格式：yyyyMM-ddHHmmss）",required = true)
    private  String inTime	;
    @ApiModelProperty(value = "减免金额(0代表无减免) 默认0")
    private  Integer deduction=0;
    @ApiModelProperty(value = "优惠折扣(0代表无折扣) 默认0")
    private  Float discount= Float.valueOf(0);
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

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
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
