package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：ParkingWhetherFeeDeductionDto
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-8
 * 编写时间                : 02:38
 * 程序功能（类）描述       ：<p>
 */
public class ParkingWhetherFeeDeductionDto {
    @ApiModelProperty(value = "停车场停车记录流水号", required = true)
    private String recordId;
    @ApiModelProperty(value = "停车场编号", required = true)
    private String	code;
    @ApiModelProperty(value = "车牌号码", required = true)
    private String	plate;
    @ApiModelProperty(value = "车牌颜色（0-蓝 1-黄 2-白 3-黑）,默认0")
    private Integer plateColor=0;
    @ApiModelProperty(value = "车辆类型 （1-大型车，2-小型车，3-其他）")
    private Integer vehicleType;
    @ApiModelProperty(value = "停车平台编号", required = true)
    private String	companyCode;
    @ApiModelProperty(value = "车辆进入时间（格式：yyyyMM-ddHHmmss）", required = true)
    private String	inTime;
    @ApiModelProperty(value = "车辆出去时间（格式：yyyyMM-ddHHmmss）", required = true)
    private String	outTime;

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
}
