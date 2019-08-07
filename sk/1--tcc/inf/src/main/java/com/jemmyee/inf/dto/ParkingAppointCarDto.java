package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/9/7.
 */
public class ParkingAppointCarDto {
    @ApiModelProperty(value = "车牌号码",required = true)
    private String plate;

    @ApiModelProperty(value = "车牌颜色（0-蓝 1-黄 2-白 3-黑）",required = true)
    private Short plateColor;

    @ApiModelProperty(value = "车辆类型 （1-大型车，2-小型车，3-其他）")
    private Short vehicleType;

    @ApiModelProperty(value = "停车场编号",required = true)
    private String code;

    @ApiModelProperty(value = "停车平台编号",required = true)
    private String companyCode;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Short getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Short plateColor) {
        this.plateColor = plateColor;
    }

    public Short getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Short vehicleType) {
        this.vehicleType = vehicleType;
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
}
