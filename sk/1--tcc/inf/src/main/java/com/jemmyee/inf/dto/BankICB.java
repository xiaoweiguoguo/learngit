package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

public class BankICB {
    @ApiModelProperty(value = "停车记录编号",required = true)
    private String parkingNum;
    @ApiModelProperty(value = "车牌号",required = true)
    private String plateNumber;
    @ApiModelProperty(value = "入场时间",required = true)
    private String startTime;
    @ApiModelProperty(value = "用户类型,0-一般用户,1-会员",required = true)
    private Integer userStatus;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
}
