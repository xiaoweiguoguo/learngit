package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

public class IsCarParkingInfo {
    @ApiModelProperty(value = "停车记录id",required = true)
    private String recordId;
    @ApiModelProperty(value = "停车场编号",required = true)
    private String code;
    @ApiModelProperty(value = "停车平台编号",required = true)
    private String companyCode;
    @ApiModelProperty(value = "车牌号",required = true)
    private String plate;
    @ApiModelProperty(value = "车牌颜色 0.蓝 1.黄 2.白 3.黑")
    private Integer plateColor;
    @ApiModelProperty(value = "车辆类型 1.大型车 2.小型车 3.其他")
    private Integer vehicleType;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordid) {
        this.recordId = recordid;
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

}
