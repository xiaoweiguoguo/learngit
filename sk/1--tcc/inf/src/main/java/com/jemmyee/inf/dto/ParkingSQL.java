package com.jemmyee.inf.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 停车记录表
 * Parking
 * 数据库表：sys_parking
 */
public class ParkingSQL {

    /**
     * 主键ID
     * 表字段 : sys_parking.id
     */
    private Long id;

    /**
     * 出入口ID
     * 表字段 : sys_parking.location_id
     */
    private Long locationId;

    /**
     * 车牌号
     * 表字段 : sys_parking.plate
     */
    private String plate;

    /**
     * 车牌颜色  0-蓝 1-黄 2-黑 3-白
     * 表字段 : sys_parking.plate_color
     */
    private Short plateColor;

    /**
     * 车辆类型 0-小车 1-大车 2-电动摩托车
     * 表字段 : sys_parking.plate_type
     */
    private Short plateType;

    /**
     * 车牌分类 1军车 2医务车 3救火车 0其他
     * 表字段 : sys_parking.plate_mode
     */
    private Short plateMode;

    /**
     * 会员卡ID
     * 表字段 : sys_parking.member_id
     */
    private Long memberId;

    /**
     * 进场时间
     * 表字段 : sys_parking.in_time
     */
    private Date inTime;

    /**
     * 实际离开时间（离开时填写）
     * 表字段 : sys_parking.out_time
     */
    private Date outTime;

    /**
     * 进场方式  0-自动放行 1-手动放行
     * 表字段 : sys_parking.in_type
     */
    private Short inType;

    /**
     * 入口手动放行原因
     * 表字段 : sys_parking.in_manualReason
     */
    private String inManualreason;

    /**
     * 出场方式  0-自动放行 1-手动放行
     * 表字段 : sys_parking.out_type
     */
    private Short outType;

    /**
     * 出口手动放行原因
     * 表字段 : sys_parking.out_manualReason
     */
    private String outManualreason;

    /**
     * 进场照片
     * 表字段 : sys_parking.in_img
     */
    private String inImg;

    /**
     * 出场照片
     * 表字段 : sys_parking.out_img
     */
    private String outImg;

    /**
     * 会员类型 1-普通 2 会员 3 内部
     * 表字段 : sys_parking.type
     */
    private Short type;

    /**
     * 免费类型 1会员卡 2武汉停车用户 3内部车 4协议车 5其他
     * 表字段 : sys_parking.free_type
     */
    private Short freeType;

    /**
     * 是否免费放行 0否1是
     * 表字段 : sys_parking.is_free
     */
    private Short isFree;

    /**
     * 实缴金额
     * 表字段 : sys_parking.real_income
     */
    private BigDecimal realIncome;

    /**
     * 应缴金额
     * 表字段 : sys_parking.must_income
     */
    private BigDecimal mustIncome;

    /**
     * 支付方式 0-现金 1-微信 2支付宝 3银联 4-武汉停车自动扣费 5-会员卡 6 内部车 7协议车 8其他
     * 表字段 : sys_parking.pay_type
     */
    private Short payType;

    /**
     * 计费时长(分钟)
     * 表字段 : sys_parking.charge_minitues
     */
    private Integer chargeMinitues;

    /**
     * 抵用券ID
     * 表字段 : sys_parking.ticket_id
     */
    private Long ticketId;

    /**
     * 抵用券数量
     * 表字段 : sys_parking.ticket_num
     */
    private Integer ticketNum;

    /**
     * 抵用金额
     * 表字段 : sys_parking.ticket_money
     */
    private BigDecimal ticketMoney;

    /**
     * 状态 0-未缴费 1-已缴费
     * 表字段 : sys_parking.status
     */
    private Short status;

    /**
     * 记录创建时间
     * 表字段 : sys_parking.create_time
     */
    private Date createTime;

    /**
     * 修改时间
     * 表字段 : sys_parking.update_time
     */
    private Date updateTime;

    /**
     * 操作人
     * 表字段 : sys_parking.operator_code
     */
    private String operatorCode;

    /**
     * 武汉停车欠费额
     * 表字段 : sys_parking.whtc_arrears_money
     */
    private BigDecimal whtcArrearsMoney;

    /**
     * 武汉停车欠费更新时间
     * 表字段 : sys_parking.whtc_arrears_update_time
     */
    private Date whtcArrearsUpdateTime;

    /**
     * 出站操作人
     * 表字段 : sys_parking.out_operator_code
     */
    private String outOperatorCode;

    /**
     * 岗亭付费 0未付费 1已付费
     * 表字段 : sys_parking.sentry_box_pay
     */
    private Short sentryBoxPay;

    /**
     * 岗亭付费时间
     * 表字段 : sys_parking.sentry_box_pay_time
     */
    private Date sentryBoxPayTime;

    /**
     * 岗亭收费人代码
     * 表字段 : sys_parking.sentry_box_pay_operator_code
     */
    private String sentryBoxPayOperatorCode;

    /**
     * 中央付费超时新纪录 0否 1是
     * 表字段 : sys_parking.center_pay
     */
    private Short centerPay;

    /**
     * 武汉停车用户余额
     * 表字段 : sys_parking.user_money
     */
    private Long userMoney;

    /**
     * 抵扣时间
     * 表字段 : sys_parking.ticket_time
     */
    private Integer ticketTime;

    /**
     * 保留字段
     * 表字段 : sys_parking.ext_field1
     */
    private String extField1;

    /**
     * 保留字段
     * 表字段 : sys_parking.ext_field2
     */
    private String extField2;


    private int plateCount;

    public int getPlateCount() {
        return plateCount;
    }

    public void setPlateCount(int plateCount) {
        this.plateCount = plateCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
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

    public Short getPlateType() {
        return plateType;
    }

    public void setPlateType(Short plateType) {
        this.plateType = plateType;
    }

    public Short getPlateMode() {
        return plateMode;
    }

    public void setPlateMode(Short plateMode) {
        this.plateMode = plateMode;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Short getInType() {
        return inType;
    }

    public void setInType(Short inType) {
        this.inType = inType;
    }

    public String getInManualreason() {
        return inManualreason;
    }

    public void setInManualreason(String inManualreason) {
        this.inManualreason = inManualreason;
    }

    public Short getOutType() {
        return outType;
    }

    public void setOutType(Short outType) {
        this.outType = outType;
    }

    public String getOutManualreason() {
        return outManualreason;
    }

    public void setOutManualreason(String outManualreason) {
        this.outManualreason = outManualreason;
    }

    public String getInImg() {
        return inImg;
    }

    public void setInImg(String inImg) {
        this.inImg = inImg;
    }

    public String getOutImg() {
        return outImg;
    }

    public void setOutImg(String outImg) {
        this.outImg = outImg;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getFreeType() {
        return freeType;
    }

    public void setFreeType(Short freeType) {
        this.freeType = freeType;
    }

    public Short getIsFree() {
        return isFree;
    }

    public void setIsFree(Short isFree) {
        this.isFree = isFree;
    }

    public BigDecimal getRealIncome() {
        return realIncome;
    }

    public void setRealIncome(BigDecimal realIncome) {
        this.realIncome = realIncome;
    }

    public BigDecimal getMustIncome() {
        return mustIncome;
    }

    public void setMustIncome(BigDecimal mustIncome) {
        this.mustIncome = mustIncome;
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    public Integer getChargeMinitues() {
        return chargeMinitues;
    }

    public void setChargeMinitues(Integer chargeMinitues) {
        this.chargeMinitues = chargeMinitues;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    public BigDecimal getTicketMoney() {
        return ticketMoney;
    }

    public void setTicketMoney(BigDecimal ticketMoney) {
        this.ticketMoney = ticketMoney;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public BigDecimal getWhtcArrearsMoney() {
        return whtcArrearsMoney;
    }

    public void setWhtcArrearsMoney(BigDecimal whtcArrearsMoney) {
        this.whtcArrearsMoney = whtcArrearsMoney;
    }

    public Date getWhtcArrearsUpdateTime() {
        return whtcArrearsUpdateTime;
    }

    public void setWhtcArrearsUpdateTime(Date whtcArrearsUpdateTime) {
        this.whtcArrearsUpdateTime = whtcArrearsUpdateTime;
    }

    public String getOutOperatorCode() {
        return outOperatorCode;
    }

    public void setOutOperatorCode(String outOperatorCode) {
        this.outOperatorCode = outOperatorCode;
    }

    public Short getSentryBoxPay() {
        return sentryBoxPay;
    }

    public void setSentryBoxPay(Short sentryBoxPay) {
        this.sentryBoxPay = sentryBoxPay;
    }

    public Date getSentryBoxPayTime() {
        return sentryBoxPayTime;
    }

    public void setSentryBoxPayTime(Date sentryBoxPayTime) {
        this.sentryBoxPayTime = sentryBoxPayTime;
    }

    public String getSentryBoxPayOperatorCode() {
        return sentryBoxPayOperatorCode;
    }

    public void setSentryBoxPayOperatorCode(String sentryBoxPayOperatorCode) {
        this.sentryBoxPayOperatorCode = sentryBoxPayOperatorCode;
    }

    public Short getCenterPay() {
        return centerPay;
    }

    public void setCenterPay(Short centerPay) {
        this.centerPay = centerPay;
    }

    public Long getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Long userMoney) {
        this.userMoney = userMoney;
    }

    public Integer getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(Integer ticketTime) {
        this.ticketTime = ticketTime;
    }

    public String getExtField1() {
        return extField1;
    }

    public void setExtField1(String extField1) {
        this.extField1 = extField1;
    }

    public String getExtField2() {
        return extField2;
    }

    public void setExtField2(String extField2) {
        this.extField2 = extField2;
    }

}