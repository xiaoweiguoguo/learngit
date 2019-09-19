package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：ParkingNoticeOutDto
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-15
 * 编写时间                : 09:31
 * 程序功能（类）描述       ：<p>
 */
public class ParkingNoticeOutDto {
    @ApiModelProperty(value = "扣费请求流水号（订单编号）",required = true)
    private String	paymentAppId;
    @ApiModelProperty(value = "停车场停车记录流水号（停车场记录的唯一标识）",required = true)
    private String	recordId;
    @ApiModelProperty(value = "停车场编号（系统自动生成并派发）",required = true)
    private String	 code;
    @ApiModelProperty(value = "车牌号码",required = true)
    private String	plate;
    @ApiModelProperty(value = "车牌颜色（0-蓝 1-黄 2-白 3-黑）默认0",required = true)
    private Integer plateColor=0;
    @ApiModelProperty(value = "车辆类型 （1-大型车，2-小型车，3-其他）",required = true)
    private  Integer	vehicleType;
    @ApiModelProperty(value = "停车平台编号",required = true)
    private String	companyCode;
    @ApiModelProperty(value = "车辆进入时间（20170622141615）",required = true)
    private  String	inTime;
    @ApiModelProperty(value = "车辆离开时间（20170622141615）",required = true)
    private  String	outTime;
    @ApiModelProperty(value = "应付费用（分）",required = true)
    private  Integer	payFee;
    @ApiModelProperty(value = "订单产生时间（20170622141615）",required = true)
    private String	 paymentTime;

    public String getPaymentAppId() {
        return paymentAppId;
    }

    public void setPaymentAppId(String paymentAppId) {
        this.paymentAppId = paymentAppId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
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

    public Integer getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Integer vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Integer getPayFee() {
        return payFee;
    }

    public void setPayFee(Integer payFee) {
        this.payFee = payFee;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

}
