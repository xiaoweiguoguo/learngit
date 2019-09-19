package com.jemmyee.inf.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：AllianceWhetherFeePlatformVo
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-13
 * 编写时间                : 09:01
 * 程序功能（类）描述       ：<p>
 */
public class AllianceWhetherFeePlatformVo {
    @ApiModelProperty(value = "扣费请求流水号（订单编号）",required = true)
    private String	 paymentAppId;
    @ApiModelProperty(value = " 停车场编号",required = true)
    private String	code;
    @ApiModelProperty(value = " 运营公司编号",required = true)
    private String companyCode;
    @ApiModelProperty(value = " 停车唯一记录编号",required = true)
    private  String recordId;
    @ApiModelProperty(value = "泊位编号（路内填写泊位号，路外可为空）")
    private  String berthCode;
    @ApiModelProperty(value = "停车场类别（1-路内，2-路外）")
    private Integer	category;
    @ApiModelProperty(value = "车牌号码",required = true)
    private String	plate;
    @ApiModelProperty(value = " 车牌颜色（0-蓝 1-黄 2-白 3-黑）默认0")
    private  Integer plateColor=0;
    @ApiModelProperty(value = " 车辆类型 （1-大型车，2-小型车，3-其他）")
    private  Integer vehicleType;
    @ApiModelProperty(value = "车辆进入时间（20170622141615）",required = true)
    private  String	 inTime;
    @ApiModelProperty(value = "车辆离开时间（20170622141615）",required = true)
    private String outTime;
    @ApiModelProperty(value = "应付费用（分）",required = true)
    private  Integer payFee;
    @ApiModelProperty(value = "扣费请求结果流水号（平台订单编号）",required = true)
    private String paymentResultId;
    @ApiModelProperty(value = "处理结果 0-处理成功 1-处理失败 2-未知错误",required = true)
    private  Integer	status;

    public String getPaymentAppId() {
        return paymentAppId;
    }

    public void setPaymentAppId(String paymentAppId) {
        this.paymentAppId = paymentAppId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getBerthCode() {
        return berthCode;
    }

    public void setBerthCode(String berthCode) {
        this.berthCode = berthCode;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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

    public String getPaymentResultId() {
        return paymentResultId;
    }

    public void setPaymentResultId(String paymentResultId) {
        this.paymentResultId = paymentResultId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
