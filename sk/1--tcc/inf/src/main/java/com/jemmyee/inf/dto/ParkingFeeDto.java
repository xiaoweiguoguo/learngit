package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lenovo on 2017/9/6.
 */
public class ParkingFeeDto {

    @ApiModelProperty(value = "停车场编号",required = true)
    private String code;

    @ApiModelProperty(value = "运营公司编号",required = true)
    private String companyCode;

    @ApiModelProperty(value = "停车唯一记录编号",required = true)
    private String recordId;

    @ApiModelProperty(value = "车牌号码",required = true)
    private String plate;

    @ApiModelProperty(value = "车牌颜色（0-蓝 1-黄 2-白 3-黑）",required = true)
    private Integer plateColor;

    @ApiModelProperty(value = "车辆离开时间（20170622141615）",required = true)
    private String outTime;

    @ApiModelProperty(value = "扣费请求流水号（订单编号）")
    private String paymentId;

    @ApiModelProperty(value = "实缴金额")
    private String realincome;

    @ApiModelProperty(value = "账户欠费金额")
    private  Integer acctArrearAmount;

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @ApiModelProperty(value = "")
    private Short status;

    public Integer getAcctArrearAmount() {
        return acctArrearAmount;
    }

    public void setAcctArrearAmount(Integer acctArrearAmount) {
        this.acctArrearAmount = acctArrearAmount;
    }

    public String getRealincome() {
        return realincome;
    }

    public void setRealincome(String realincome) {
        this.realincome = realincome;
    }

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

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }
}
