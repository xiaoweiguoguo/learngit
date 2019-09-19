package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class UserInfosDto {
    public BigDecimal getUsermoney() {
        return usermoney;
    }

    public void setUsermoney(BigDecimal usermoney) {
        this.usermoney = usermoney;
    }

    public String getExtfield1() {
        return extfield1;
    }

    public void setExtfield1(String extfield1) {
        this.extfield1 = extfield1;
    }

    public String getFreetype() {
        return freetype;
    }

    public void setFreetype(String freetype) {
        this.freetype = freetype;
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

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    /**
     * 停车场余额
     * INF_PARKINFO.user_money
     * @mbggenerated
     */
    @ApiModelProperty(value = "武汉停车用户余额")
    private BigDecimal usermoney;

    /**
     * 可扣费状态
     * INF_PARKINFO.ext_field1
     * @mbggenerated
     */
    @ApiModelProperty(value = "可扣费状态")
    private String extfield1;

    /**
     * 用户身份
     * INF_PARKINFO.free_type
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户身份")
    private String freetype;

    /**
     * 停车平台编号
     * INF_PARKINFO.COMPANYCODE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车平台编号",required = true)
    private String companyCode;

    /**
     * 停车场编号
     * INF_PARKINFO.CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场编号",required = true)
    private String code;

    /**
     * 停车场停车记录流水号
     * INF_PARKINFO.recordId
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场停车记录流水号（停车场记录的唯一标识）",required = true)
    private String recordId;

    @ApiModelProperty(value = "账户欠费金额")
    private  Integer acctArrearAmount;

    public Integer getAcctArrearAmount() {
        return acctArrearAmount;
    }

    public void setAcctArrearAmount(Integer acctArrearAmount) {
        this.acctArrearAmount = acctArrearAmount;
    }
}
