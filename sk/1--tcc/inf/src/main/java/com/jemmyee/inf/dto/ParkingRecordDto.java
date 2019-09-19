package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lenovo on 2017/9/6.
 */
public class ParkingRecordDto {

    @ApiModelProperty(value = "停车场停车记录流水号（停车场记录的唯一标识）",required = true)
    private String recordId;

    @ApiModelProperty(value = "停车场编号",required = true)
    private String code;

    @ApiModelProperty(value = "联盟平台编号",required = true)
    private String platformCode;

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

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }
}
