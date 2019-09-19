package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 文件名称                ：PostParkingFeeDto
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-6
 * 编写时间                : 11:01
 * 程序功能（类）描述       ：自建停车场车辆向联盟平台中心提交时段收费信息的请求参数
 */
public class PostParkingFeeDto {
    @ApiModelProperty(value = "停车记录流水号", required = true)
    private String recordId;
    @ApiModelProperty(value = "停车平台编号", required = true)
    private String companyCode;
    @ApiModelProperty(value = "停车场编号", required = true)
    private String code;
    @ApiModelProperty(value = "车牌号码", required = true)
    private String plate;
    @ApiModelProperty(value = "车牌颜色 0-蓝 1-黄 2-白 3-黑,默认0")
    private Integer plateColor = 0;
    @ApiModelProperty(value = "车辆入场时间号（格式：yyyyMMddHHmmss）", required = true)
    private String inTime;
    @ApiModelProperty(value = "收费截止时间1（格式：yyyyMMddHHmmss）", required = true)
    private String outTime1;
    @ApiModelProperty(value = "截止时间1费用", required = true)
    private Integer payFee1;
    @ApiModelProperty(value = "收费截止时间2（格式：yyyyMMddHHmmss）", required = true)
    private String outTime2;
    @ApiModelProperty(value = "截止时间2费用", required = true)
    private Integer payFee2;
    @ApiModelProperty(value = "收费截止3时间（格式：yyyyMMddHHmmss）", required = true)
    private String outTime3;
    @ApiModelProperty(value = "截止时间3费用", required = true)
    private Integer payFee3;
    @ApiModelProperty(value = "收费截止4时间（格式：yyyyMMddHHmmss）", required = true)
    private String outTime4;
    @ApiModelProperty(value = "截止时间4费用", required = true)
    private Integer payFee4;
    @ApiModelProperty(value = "收费截止5时间（格式：yyyyMMddHHmmss）", required = true)
    private String outTime5;
    @ApiModelProperty(value = "截止时间5费用", required = true)
    private Integer payFee5;
    @ApiModelProperty(value = "收费截止6时间（格式：yyyyMMddHHmmss）", required = true)
    private String outTime6;
    @ApiModelProperty(value = "截止时间6费用", required = true)
    private Integer payFee6;
    @ApiModelProperty(value = "收费截止7时间（格式：yyyyMMddHHmmss）", required = true)
    private String outTime7;
    @ApiModelProperty(value = "截止时间7费用", required = true)
    private Integer payFee7;
    @ApiModelProperty(value = "收费截止8时间（格式：yyyyMMddHHmmss）", required = true)
    private String outTime8;
    @ApiModelProperty(value = "截止时间8费用", required = true)
    private Integer payFee8;
    @ApiModelProperty(value = "收费截止时9间（格式：yyyyMMddHHmmss）", required = true)
    private String outTime9;
    @ApiModelProperty(value = "截止时间9费用", required = true)
    private Integer payFee9;
    @ApiModelProperty(value = "收费截止时间10（格式：yyyyMMddHHmmss）", required = true)
    private String outTime10;
    @ApiModelProperty(value = "截止时间10费用", required = true)
    private Integer payFee10;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime1() {
        return outTime1;
    }

    public void setOutTime1(String outTime1) {
        this.outTime1 = outTime1;
    }

    public Integer getPayFee1() {
        return payFee1;
    }

    public void setPayFee1(Integer payFee1) {
        this.payFee1 = payFee1;
    }

    public String getOutTime2() {
        return outTime2;
    }

    public void setOutTime2(String outTime2) {
        this.outTime2 = outTime2;
    }

    public Integer getPayFee2() {
        return payFee2;
    }

    public void setPayFee2(Integer payFee2) {
        this.payFee2 = payFee2;
    }

    public String getOutTime3() {
        return outTime3;
    }

    public void setOutTime3(String outTime3) {
        this.outTime3 = outTime3;
    }

    public Integer getPayFee3() {
        return payFee3;
    }

    public void setPayFee3(Integer payFee3) {
        this.payFee3 = payFee3;
    }

    public String getOutTime4() {
        return outTime4;
    }

    public void setOutTime4(String outTime4) {
        this.outTime4 = outTime4;
    }

    public Integer getPayFee4() {
        return payFee4;
    }

    public void setPayFee4(Integer payFee4) {
        this.payFee4 = payFee4;
    }

    public String getOutTime5() {
        return outTime5;
    }

    public void setOutTime5(String outTime5) {
        this.outTime5 = outTime5;
    }

    public Integer getPayFee5() {
        return payFee5;
    }

    public void setPayFee5(Integer payFee5) {
        this.payFee5 = payFee5;
    }

    public String getOutTime6() {
        return outTime6;
    }

    public void setOutTime6(String outTime6) {
        this.outTime6 = outTime6;
    }

    public Integer getPayFee6() {
        return payFee6;
    }

    public void setPayFee6(Integer payFee6) {
        this.payFee6 = payFee6;
    }

    public String getOutTime7() {
        return outTime7;
    }

    public void setOutTime7(String outTime7) {
        this.outTime7 = outTime7;
    }

    public Integer getPayFee7() {
        return payFee7;
    }

    public void setPayFee7(Integer payFee7) {
        this.payFee7 = payFee7;
    }

    public String getOutTime8() {
        return outTime8;
    }

    public void setOutTime8(String outTime8) {
        this.outTime8 = outTime8;
    }

    public Integer getPayFee8() {
        return payFee8;
    }

    public void setPayFee8(Integer payFee8) {
        this.payFee8 = payFee8;
    }

    public String getOutTime9() {
        return outTime9;
    }

    public void setOutTime9(String outTime9) {
        this.outTime9 = outTime9;
    }

    public Integer getPayFee9() {
        return payFee9;
    }

    public void setPayFee9(Integer payFee9) {
        this.payFee9 = payFee9;
    }

    public String getOutTime10() {
        return outTime10;
    }

    public void setOutTime10(String outTime10) {
        this.outTime10 = outTime10;
    }

    public Integer getPayFee10() {
        return payFee10;
    }

    public void setPayFee10(Integer payFee10) {
        this.payFee10 = payFee10;
    }


}
