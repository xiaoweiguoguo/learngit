package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：AllianceWhetherFeePlatformDto
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-8
 * 编写时间                : 10:41
 * 程序功能（类）描述       ：<p>
 */
public class AllianceWhetherFeePlatformDto {
    @ApiModelProperty(value = "车牌号码", required = true)
    private String	plate;
    @ApiModelProperty(value = "车牌颜色（0-蓝 1-黄 2-白 3-黑）,默认0")
    private Integer plateColor=0;
    @ApiModelProperty(value = "车辆类型 （1-大型车，2-小型车，3-其他）")
    private Integer vehicleType;
    @ApiModelProperty(value = "停车平台编号", required = true)
    private String	companyCode;

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
}
