package com.jemmyee.inf.vo;

import com.jemmyee.inf.entity.ParkInfo;
import com.jemmyee.inf.entity.Parking;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/6.
 */
public class AppointCarResultVo {
    //停车场停车记录流水号（停车场记录的唯一标识）
    private String recordId;

    //停车场编号
    private String code;

    //停车场名称
    private String name;

    //车牌号
    private String plate;

    //车牌颜色（0-蓝 1-黄 2-白 3-黑）
    private Short plateColor;

    //车辆类型（1-大型车，2-小型车，3-其他）
    private Short vehicleType;

    //车辆品牌
    private Short vehicleBrand;

    //停车平台编号
    private String companyCode;

    //车辆进入时间（20170622111615）
    private String inTime;

    //车辆离开时间（20170622141615）
    private String outTime;

    //当前更新时间（20170622141615）
    private String updateTime;

    //当前时间点应付金额（分）
    private String payFee;

    //状态 0-停车中 1-离开
    private Short status;

    public AppointCarResultVo(ParkInfo parkInfo, Parking parking) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        this.recordId = parking.getId();
        this.code = parking.getParkcode();
        this.name = parkInfo.getName();
        this.plate = parking.getPlate();
        this.plateColor = parking.getPlatecolor();
        this.vehicleType = parking.getVehicletype();
        this.companyCode = parking.getCompanycode();
        this.inTime = sdf.format(parking.getIntime());
        if (parking.getOuttime() != null) this.outTime = sdf.format(parking.getOuttime());

        Class<? extends Parking> c = parking.getClass();
        long now = new Date().getTime();
        try {
            for (int i = 1; i < 11; i++) {
                if (((Date) c.getMethod("getOuttime" + i).invoke(parking)).getTime() < now) continue;
                this.payFee = String.valueOf(Double.valueOf(c.getMethod("getPayfee" + i).invoke(parking).toString()) * 100);
                break;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        this.updateTime = sdf.format(parking.getUpdatetime());
        if (this.outTime == null) this.status = 0;
        else this.status = 1;
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

    public Short getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(Short vehicleBrand) {
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPayFee() {
        return payFee;
    }

    public void setPayFee(String payFee) {
        this.payFee = payFee;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
