package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;


public class ParkinfosDto {
    public void setCode(String code) {
        this.code = code;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public void setEmptyNum(Integer emptyNum) {
        this.emptyNum = emptyNum;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 停车场编号
     * INF_PARKINFO.CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场编号",required = true)
    private String code;

    /**
     * 停车平台编号
     * INF_PARKINFO.COMPANYCODE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车平台编号",required = true)
    private String companyCode;

    /**
     * 总泊位数
     * INF_PARKINFO.TOTALNUM
     * @mbggenerated
     */
    @ApiModelProperty(value = "总泊位数",required = true)
    private Integer totalNum;

    /**
     * 空泊位数
     * INF_PARKINFO.EMPTYNUM
     * @mbggenerated
     */
    @ApiModelProperty(value = "空泊位数",required = true)
    private Integer emptyNum;

    /**
     * 更新时间
     * INF_PARKINFO.UPDATETIME
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间(20170926151900)",required = true)
    private String updateTime;

    public String getCode() {
        return code;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public Integer getEmptyNum() {
        return emptyNum;
    }

    public String getUpdateTime() {
        return updateTime;
    }
}
