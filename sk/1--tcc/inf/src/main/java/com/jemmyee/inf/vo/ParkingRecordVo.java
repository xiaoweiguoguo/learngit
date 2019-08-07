package com.jemmyee.inf.vo;

/**
 * Created by lenovo on 2017/9/6.
 */
public class ParkingRecordVo {

    //停车场离开流水号（停车场记录的唯一标识，可与进记录相同）
    private String recordId;

    //停车场编号
    private String code;

    //停车场名称
    private String name;

    //车牌号码
    private String plate;

    //车牌颜色（0-蓝 1-黄 2-白 3-黑）
    private Integer plateColor;

    //车辆类型 （1-大型车，2-小型车，3-其他）
    private Integer vehicleType;

    //车辆品牌
    private String vehicleBrand;

    //停车平台编号
    private String companyCode;

    //车辆进入时间（20170622111615）
    private String inTime;

    //车辆离开时间（20170622141615）
    private String outTime;

    //车辆进图片地址1
    private String vehiclePicIn1;

    //车辆进图片地址2
    private String vehiclePicIn2;

    //车辆进图片地址3
    private String vehiclePicIn3;

    //车辆出图片地址1
    private String vehiclePicOut1;

    //车辆出图片地址2
    private String vehiclePicOut2;

    //车辆出图片地址3
    private String vehiclePicOut3;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
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

    public String getVehiclePicIn1() {
        return vehiclePicIn1;
    }

    public void setVehiclePicIn1(String vehiclePicIn1) {
        this.vehiclePicIn1 = vehiclePicIn1;
    }

    public String getVehiclePicIn2() {
        return vehiclePicIn2;
    }

    public void setVehiclePicIn2(String vehiclePicIn2) {
        this.vehiclePicIn2 = vehiclePicIn2;
    }

    public String getVehiclePicIn3() {
        return vehiclePicIn3;
    }

    public void setVehiclePicIn3(String vehiclePicIn3) {
        this.vehiclePicIn3 = vehiclePicIn3;
    }

    public String getVehiclePicOut1() {
        return vehiclePicOut1;
    }

    public void setVehiclePicOut1(String vehiclePicOut1) {
        this.vehiclePicOut1 = vehiclePicOut1;
    }

    public String getVehiclePicOut2() {
        return vehiclePicOut2;
    }

    public void setVehiclePicOut2(String vehiclePicOut2) {
        this.vehiclePicOut2 = vehiclePicOut2;
    }

    public String getVehiclePicOut3() {
        return vehiclePicOut3;
    }

    public void setVehiclePicOut3(String vehiclePicOut3) {
        this.vehiclePicOut3 = vehiclePicOut3;
    }
}
