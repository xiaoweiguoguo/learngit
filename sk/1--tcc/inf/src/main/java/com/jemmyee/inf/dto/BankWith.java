package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class BankWith {
    @ApiModelProperty(value = "停车记录编号",required = true)
    private String parkingNum;
    @ApiModelProperty(value = "车牌号",required = true)
    private String plateNumber;
    @ApiModelProperty(value = "出场时间",required = true)
    private String endTime;
    @ApiModelProperty(value = "停车时长",required = true)
    private int duration;
    @ApiModelProperty(value = "停车费用(元)",required = true)
    private BigDecimal billing;

    public String getParkingNum() {
        return parkingNum;
    }

    public void setParkingNum(String parkingNum) {
        this.parkingNum = parkingNum;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getBilling() {
        return billing;
    }

    public void setBilling(BigDecimal billing) {
        this.billing = billing;
    }
}
