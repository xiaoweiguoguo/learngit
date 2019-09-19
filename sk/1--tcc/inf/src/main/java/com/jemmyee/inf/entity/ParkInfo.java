package com.jemmyee.inf.entity;

import com.jemmyee.core.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class ParkInfo {
    /**
     * 停车场编号
     * INF_PARKINFO.CODE
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场编号")
    private String code;

    /**
     * 停车场名称
     * INF_PARKINFO.NAME
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场名称")
    private String name;

    /**
     * 纬度
     * INF_PARKINFO.LAT
     * @mbggenerated
     */
    @ApiModelProperty(value = "纬度")
    private BigDecimal lat;

    /**
     * 经度
     * INF_PARKINFO.LNG
     * @mbggenerated
     */
    @ApiModelProperty(value = "经度")
    private BigDecimal lng;

    /**
     * 详细地址
     * INF_PARKINFO.ADDRESS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 停车平台编号
     * INF_PARKINFO.COMPANYCODE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车平台编号")
    private String companycode;

    /**
     * 联系方式
     * INF_PARKINFO.CONTACTWAY
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系方式")
    private String contactway;

    /**
     * 停车场类型（1-机械停车场，2-平面停车场，3-智能立体停车库，4-遥控停车场）
     * INF_PARKINFO.PKLOTTYPE
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场类型（1-机械停车场，2-平面停车场，3-智能立体停车库，4-遥控停车场）")
    private Short pklottype;

    /**
     * 停车场类别（1-路内，2-路外）
     * INF_PARKINFO.PKLOTCATEGORY
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场类别（1-路内，2-路外）")
    private Short pklotcategory;

    /**
     * 停车场属性（1-私营，2-公有）
     * INF_PARKINFO.PKLOTATTRIBUTE
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场属性（1-私营，2-公有）")
    private Short pklotattribute;

    /**
     * 停车场收费规则描述
     * INF_PARKINFO.PKLOTPAYRULE
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场收费规则描述")
    private String pklotpayrule;

    /**
     * 停车场图片1
     * INF_PARKINFO.PKLOTPIC1
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场图片1")
    private String pklotpic1;

    /**
     * 停车场图片2
     * INF_PARKINFO.PKLOTPIC2
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场图片2")
    private String pklotpic2;

    /**
     * 停车场图片3
     * INF_PARKINFO.PKLOTPIC3
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场图片3")
    private String pklotpic3;

    /**
     * 总泊位数
     * INF_PARKINFO.TOTALNUM
     * @mbggenerated
     */
    @ApiModelProperty(value = "总泊位数")
    private BigDecimal totalnum;

    /**
     * 空泊位数
     * INF_PARKINFO.EMPTYNUM
     * @mbggenerated
     */
    @ApiModelProperty(value = "空泊位数")
    private BigDecimal emptynum;

    /**
     * 当前状态 0-营运中 1-维护停用
     * INF_PARKINFO.STATUS
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前状态 0-营运中 1-维护停用")
    private Short status;

    /**
     * 数据库地址
     * INF_PARKINFO.DBURL
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库地址")
    private String dburl;

    /**
     * 数据库用户名
     * INF_PARKINFO.DBUSERID
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库用户名")
    private String dbuserid;

    /**
     * 数据库密码
     * INF_PARKINFO.DBPASSWORD
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库密码")
    private String dbpassword;

    @ApiModelProperty(value = "区域编号(1-江岸区 2-江汉区 3-硚口区 4-汉阳区 5-武昌区 6-洪山区 7-青山区 8-东西湖区 9-汉南区 10-蔡甸区 11-江夏区 12-黄陂区 13-新洲区 14-市辖区)",required = true)
    private String districtCode;

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDburl() {
        return dburl;
    }

    public void setDburl(String dburl) {
        this.dburl = dburl;
    }

    public String getDbuserid() {
        return dbuserid;
    }

    public void setDbuserid(String dbuserid) {
        this.dbuserid = dbuserid;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.CODE
     *
     * @return the value of INF_PARKINFO.CODE
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.CODE
     *
     * @param code the value for INF_PARKINFO.CODE
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.NAME
     *
     * @return the value of INF_PARKINFO.NAME
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.NAME
     *
     * @param name the value for INF_PARKINFO.NAME
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.LAT
     *
     * @return the value of INF_PARKINFO.LAT
     *
     * @mbggenerated
     */
    public BigDecimal getLat() {
        return lat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.LAT
     *
     * @param lat the value for INF_PARKINFO.LAT
     *
     * @mbggenerated
     */
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.LNG
     *
     * @return the value of INF_PARKINFO.LNG
     *
     * @mbggenerated
     */
    public BigDecimal getLng() {
        return lng;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.LNG
     *
     * @param lng the value for INF_PARKINFO.LNG
     *
     * @mbggenerated
     */
    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.ADDRESS
     *
     * @return the value of INF_PARKINFO.ADDRESS
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.ADDRESS
     *
     * @param address the value for INF_PARKINFO.ADDRESS
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.COMPANYCODE
     *
     * @return the value of INF_PARKINFO.COMPANYCODE
     *
     * @mbggenerated
     */
    public String getCompanycode() {
        return companycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.COMPANYCODE
     *
     * @param companycode the value for INF_PARKINFO.COMPANYCODE
     *
     * @mbggenerated
     */
    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.CONTACTWAY
     *
     * @return the value of INF_PARKINFO.CONTACTWAY
     *
     * @mbggenerated
     */
    public String getContactway() {
        return contactway;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.CONTACTWAY
     *
     * @param contactway the value for INF_PARKINFO.CONTACTWAY
     *
     * @mbggenerated
     */
    public void setContactway(String contactway) {
        this.contactway = contactway;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.PKLOTTYPE
     *
     * @return the value of INF_PARKINFO.PKLOTTYPE
     *
     * @mbggenerated
     */
    public Short getPklottype() {
        return pklottype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.PKLOTTYPE
     *
     * @param pklottype the value for INF_PARKINFO.PKLOTTYPE
     *
     * @mbggenerated
     */
    public void setPklottype(Short pklottype) {
        this.pklottype = pklottype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.PKLOTCATEGORY
     *
     * @return the value of INF_PARKINFO.PKLOTCATEGORY
     *
     * @mbggenerated
     */
    public Short getPklotcategory() {
        return pklotcategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.PKLOTCATEGORY
     *
     * @param pklotcategory the value for INF_PARKINFO.PKLOTCATEGORY
     *
     * @mbggenerated
     */
    public void setPklotcategory(Short pklotcategory) {
        this.pklotcategory = pklotcategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.PKLOTATTRIBUTE
     *
     * @return the value of INF_PARKINFO.PKLOTATTRIBUTE
     *
     * @mbggenerated
     */
    public Short getPklotattribute() {
        return pklotattribute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.PKLOTATTRIBUTE
     *
     * @param pklotattribute the value for INF_PARKINFO.PKLOTATTRIBUTE
     *
     * @mbggenerated
     */
    public void setPklotattribute(Short pklotattribute) {
        this.pklotattribute = pklotattribute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.PKLOTPAYRULE
     *
     * @return the value of INF_PARKINFO.PKLOTPAYRULE
     *
     * @mbggenerated
     */
    public String getPklotpayrule() {
        return pklotpayrule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.PKLOTPAYRULE
     *
     * @param pklotpayrule the value for INF_PARKINFO.PKLOTPAYRULE
     *
     * @mbggenerated
     */
    public void setPklotpayrule(String pklotpayrule) {
        this.pklotpayrule = pklotpayrule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.PKLOTPIC1
     *
     * @return the value of INF_PARKINFO.PKLOTPIC1
     *
     * @mbggenerated
     */
    public String getPklotpic1() {
        return pklotpic1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.PKLOTPIC1
     *
     * @param pklotpic1 the value for INF_PARKINFO.PKLOTPIC1
     *
     * @mbggenerated
     */
    public void setPklotpic1(String pklotpic1) {
        this.pklotpic1 = pklotpic1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.PKLOTPIC2
     *
     * @return the value of INF_PARKINFO.PKLOTPIC2
     *
     * @mbggenerated
     */
    public String getPklotpic2() {
        return pklotpic2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.PKLOTPIC2
     *
     * @param pklotpic2 the value for INF_PARKINFO.PKLOTPIC2
     *
     * @mbggenerated
     */
    public void setPklotpic2(String pklotpic2) {
        this.pklotpic2 = pklotpic2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.PKLOTPIC3
     *
     * @return the value of INF_PARKINFO.PKLOTPIC3
     *
     * @mbggenerated
     */
    public String getPklotpic3() {
        return pklotpic3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.PKLOTPIC3
     *
     * @param pklotpic3 the value for INF_PARKINFO.PKLOTPIC3
     *
     * @mbggenerated
     */
    public void setPklotpic3(String pklotpic3) {
        this.pklotpic3 = pklotpic3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.TOTALNUM
     *
     * @return the value of INF_PARKINFO.TOTALNUM
     *
     * @mbggenerated
     */
    public BigDecimal getTotalnum() {
        return totalnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.TOTALNUM
     *
     * @param totalnum the value for INF_PARKINFO.TOTALNUM
     *
     * @mbggenerated
     */
    public void setTotalnum(BigDecimal totalnum) {
        this.totalnum = totalnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.EMPTYNUM
     *
     * @return the value of INF_PARKINFO.EMPTYNUM
     *
     * @mbggenerated
     */
    public BigDecimal getEmptynum() {
        return emptynum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.EMPTYNUM
     *
     * @param emptynum the value for INF_PARKINFO.EMPTYNUM
     *
     * @mbggenerated
     */
    public void setEmptynum(BigDecimal emptynum) {
        this.emptynum = emptynum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKINFO.STATUS
     *
     * @return the value of INF_PARKINFO.STATUS
     *
     * @mbggenerated
     */
    public Short getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKINFO.STATUS
     *
     * @param status the value for INF_PARKINFO.STATUS
     *
     * @mbggenerated
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}