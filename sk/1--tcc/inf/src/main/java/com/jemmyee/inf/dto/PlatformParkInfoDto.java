package com.jemmyee.inf.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.File;

/**
 * Created by lenovo on 2017/9/18.
 */
public class PlatformParkInfoDto {

    @ApiModelProperty(value = "停车场编号",required = true)
    private String code;
    @ApiModelProperty(value = "停车场名称",required = true)
    private String name;
    @ApiModelProperty(value = "总泊位数",required = true)
    private Integer totalNum;
    @ApiModelProperty(value = "纬度",required = true)
    private Number lat;
    @ApiModelProperty(value = "经度",required = true)
    private Number lng;
    @ApiModelProperty(value = "停车场详细地址",required = true)
    private String address;
    @ApiModelProperty(value = "停车平台编号",required = true)
    private String companyCode;
    @ApiModelProperty(value = "区域编号(1-江岸区 2-江汉区 3-硚口区 4-汉阳区 5-武昌区 6-洪山区 7-青山区 8-东西湖区 9-汉南区 10-蔡甸区 11-江夏区 12-黄陂区 13-新洲区 14-市辖区)",required = true)
    private String districtCode;
    @ApiModelProperty(value = "停车场类型（1-机械停车场，2-平面停车场，3-智能立体停车库，4-遥控停车场）",required = true)
    private Integer pkLotType;
    @ApiModelProperty(value = "停车场类别（1-路内，2-路外）",required = true)
    private Integer pkLotCategory;
    @ApiModelProperty(value = "停车场属性（1-私营，2-公有）",required = true)
    private Integer pkLotAttribute;
    @ApiModelProperty(value = "停车场收费规则描述",required = true)
    private String pkLotPayRule;
    @ApiModelProperty(value = "停车场图片1",required = true)
    private File pkLotPic1;
    @ApiModelProperty(value = "停车场图片2",required = true)
    private File pkLotPic2;
    @ApiModelProperty(value = "停车场图片3",required = true)
    private File pkLotPic3;

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

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Number getLat() {
        return lat;
    }

    public void setLat(Number lat) {
        this.lat = lat;
    }

    public Number getLng() {
        return lng;
    }

    public void setLng(Number lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public Integer getPkLotType() {
        return pkLotType;
    }

    public void setPkLotType(Integer pkLotType) {
        this.pkLotType = pkLotType;
    }

    public Integer getPkLotCategory() {
        return pkLotCategory;
    }

    public void setPkLotCategory(Integer pkLotCategory) {
        this.pkLotCategory = pkLotCategory;
    }

    public Integer getPkLotAttribute() {
        return pkLotAttribute;
    }

    public void setPkLotAttribute(Integer pkLotAttribute) {
        this.pkLotAttribute = pkLotAttribute;
    }

    public String getPkLotPayRule() {
        return pkLotPayRule;
    }

    public void setPkLotPayRule(String pkLotPayRule) {
        this.pkLotPayRule = pkLotPayRule;
    }

    public File getPkLotPic1() {
        return pkLotPic1;
    }

    public void setPkLotPic1(File pkLotPic1) {
        this.pkLotPic1 = pkLotPic1;
    }

    public File getPkLotPic2() {
        return pkLotPic2;
    }

    public void setPkLotPic2(File pkLotPic2) {
        this.pkLotPic2 = pkLotPic2;
    }

    public File getPkLotPic3() {
        return pkLotPic3;
    }

    public void setPkLotPic3(File pkLotPic3) {
        this.pkLotPic3 = pkLotPic3;
    }
}
