package com.jemmyee.inf.entity;

import com.jemmyee.core.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class Parking {
    /**
     * 停车记录标识
     * INF_PARKING.ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车记录标识",required = true)
    private String id;

    /**
     * 停车场编号
     * INF_PARKING.PARKCODE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场编号",required = true)
    private String parkcode;

    /**
     * 停车平台编号
     * INF_PARKING.COMPANYCODE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车平台编号",required = true)
    private String companycode;

    /**
     * 车牌号
     * INF_PARKING.PLATE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "车牌号码",required = true)
    private String plate;

    /**
     * 车牌颜色 0-蓝 1-黄 2-白 3-黑
     * INF_PARKING.PLATECOLOR
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "车牌颜色（0-蓝 1-黄 2-白 3-黑）",required = true)
    private Short platecolor;

    /**
     * T1-大型车，2-小型车，3-其他
     * INF_PARKING.VEHICLETYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "车辆类型 （1-大型车，2-小型车，3-其他）")
    private Short vehicletype;

    /**
     * 0-自有路外停车场 1-路内泊位 2-第三方停车场
     * INF_PARKING.PARKTYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "停车场类型 0-自有路外停车场 1-路内泊位 2-第三方停车场",required = true)
    private Short parktype;

    /**
     * 泊位号
     * INF_PARKING.BERTHCODE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "泊位号")
    private String berthcode;

    /**
     * 进场时间
     * INF_PARKING.INTIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "进场时间",required = true)
    private Date intime;

    /**
     * 出场时间
     * INF_PARKING.OUTTIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出场时间")
    private Date outtime;

    /**
     * 0-未缴 1-已缴
     * INF_PARKING.PAYSTATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态 0-未缴 1-已缴",required = true)
    private Short paystatus;

    /**
     * 实缴金额
     * INF_PARKING.REALPAYCASH
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "实缴金额")
    private BigDecimal realpaycash;

    /**
     * 应缴金额
     * INF_PARKING.MUSTPAYCASH
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应缴金额")
    private BigDecimal mustpaycash;

    /**
     * 0-现金 1-在线支付
     * INF_PARKING.PAYTYPE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "支付方式 0-现金 1-在线支付")
    private Short paytype;

    /**
     * 未来出场时间1
     * INF_PARKING.OUTTIME1
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "未来出场时间1")
    private Date outtime1;

    /**未来出场时间1
     * 应付费用1
     * INF_PARKING.PAYFEE1
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应付费用1")
    private BigDecimal payfee1;

    /**
     * 未来出场时间2
     * INF_PARKING.OUTTIME2
     *
     * @mbggenerated
     */
    private Date outtime2;

    /**
     * 应付费用2
     * This field was generated by MyBatis Generator.
     * INF_PARKING.PAYFEE2
     *
     * @mbggenerated
     */
    private BigDecimal payfee2;

    /**
     * 未来出场时间3
     * INF_PARKING.OUTTIME3
     *
     * @mbggenerated
     */
    private Date outtime3;

    /**
     * 应付费用3
     * INF_PARKING.PAYFEE3
     *
     * @mbggenerated
     */
    private BigDecimal payfee3;

    /**
     * 未来出场时间4
     * INF_PARKING.OUTTIME4
     *
     * @mbggenerated
     */
    private Date outtime4;

    /**
     * 应付费用4
     * INF_PARKING.PAYFEE4
     *
     * @mbggenerated
     */
    private BigDecimal payfee4;

    /**
     * 未来出场时间5
     * INF_PARKING.OUTTIME5
     *
     * @mbggenerated
     */
    private Date outtime5;

    /**
     * 应付费用5
     * INF_PARKING.PAYFEE5
     *
     * @mbggenerated
     */
    private BigDecimal payfee5;

    /**
     * 未来出场时间6
     * INF_PARKING.OUTTIME6
     *
     * @mbggenerated
     */
    private Date outtime6;

    /**
     * 应付费用6
     * INF_PARKING.PAYFEE6
     *
     * @mbggenerated
     */
    private BigDecimal payfee6;

    /**
     * 未来出场时间7
     * INF_PARKING.OUTTIME7
     *
     * @mbggenerated
     */
    private Date outtime7;

    /**
     * 应付费用7
     * INF_PARKING.PAYFEE7
     *
     * @mbggenerated
     */
    private BigDecimal payfee7;

    /**
     * 未来出场时间8
     * INF_PARKING.OUTTIME8
     *
     * @mbggenerated
     */
    private Date outtime8;

    /**
     * 应付费用8
     * INF_PARKING.PAYFEE8
     *
     * @mbggenerated
     */
    private BigDecimal payfee8;

    /**
     * T未来出场时间9
     * INF_PARKING.OUTTIME9
     *
     * @mbggenerated
     */
    private Date outtime9;

    /**
     * 应付费用9
     * INF_PARKING.PAYFEE9
     *
     * @mbggenerated
     */
    private BigDecimal payfee9;

    /**
     * 未来出场时间10
     * INF_PARKING.OUTTIME10
     *
     * @mbggenerated
     */
    private Date outtime10;

    /**
     * 应付费用10
     * INF_PARKING.PAYFEE10
     *
     * @mbggenerated
     */
    private BigDecimal payfee10;

    /**
     * 车辆进图片
     * INF_PARKING.VEHICLEPICIN
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "车辆进图片")
    private String vehiclepicin;

    /**
     * 车辆出图片
     * INF_PARKING.VEHICLEPICOUT
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "车辆出图片")
    private String vehiclepicout;

    /**
     * 0-否 1-是
     * INF_PARKING.ISPLATFORMUSER
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否平台用户 0-否 1-是")
    private Short isplatformuser;

    /**
     * 平台用户信息
     * INF_PARKING.PLATFORMUSERINFO
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台用户信息")
    private String platformuserinfo;

    /**
     * 0-未申请 1-已申请 2-已扣费 3-扣费失败
     * INF_PARKING.APPAPPLYSTATUS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "app申请状态 0-未申请 1-已申请 2-已扣费 3-扣费失败")
    private BigDecimal appapplystatus;

    /**
     * app申请时间
     * INF_PARKING.APPAPPLYTIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "app申请时间")
    private Date appapplytime;

    /**
     * app扣费时间
     * INF_PARKING.APPFEETIME
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "app扣费时间")
    private Date appfeetime;

    /**
     * app申请扣费金额
     * INF_PARKING.APPAPPLYFEE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "app申请扣费金额")
    private BigDecimal appapplyfee;

    /**
     * app实际扣费金额
     * INF_PARKING.APPREALFEE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "app实际扣费金额")
    private BigDecimal apprealfee;

    /**
     * 支付平台编号
     * INF_PARKING.APPPAYPLATFORM
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "支付平台编号")
    private String apppayplatform;

    /**
     * app申请扣费流水号
     * INF_PARKING.APPAPPLYORDER
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "app申请扣费流水号")
    private String appapplyorder;

    /**
     * 平台扣费流水号
     * INF_PARKING.PLATFORMFEEORDER
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台扣费流水号")
    private String platformfeeorder;

    /**
     * 修改时间
     * INF_PARKING.UPDATETIME

     * @mbggenerated
     */
    @ApiModelProperty(value = "修改时间",hidden = true)
    private Date updatetime;


    /**
     * 车辆类型0.临时车 1.内部车 2.会员车
     * INF_PARKING.CARTYPE

     * @mbggenerated
     */

    @ApiModelProperty(value = "车辆类型0.临时车 1.内部车 2.会员车")
    private Short cartype;


    public BigDecimal getTicketnum() {
        return ticketnum;
    }

    public void setTicketnum(BigDecimal ticketnum) {
        this.ticketnum = ticketnum;
    }

    public BigDecimal getTicketid() {
        return ticketid;
    }

    public void setTicketid(BigDecimal ticketid) {
        this.ticketid = ticketid;
    }

    /**
     * 优惠券数量
     * INF_PARKING.CARTYPE

     * @mbggenerated
     */

    @ApiModelProperty(value = "优惠券数量")
    private BigDecimal ticketnum;



    /**
     * 优惠券数量
     * INF_PARKING.CARTYPE

     * @mbggenerated
     */

    @ApiModelProperty(value = "优惠券id")
    private BigDecimal ticketid;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.ID
     *
     * @return the value of INF_PARKING.ID
     *
     * @mbggenerated
     */


    public Short getCartype() {
        return cartype;
    }

    public void setCartype(Short cartype) {
        this.cartype = cartype;
    }

    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.ID
     *
     * @param id the value for INF_PARKING.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PARKCODE
     *
     * @return the value of INF_PARKING.PARKCODE
     *
     * @mbggenerated
     */
    public String getParkcode() {
        return parkcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PARKCODE
     *
     * @param parkcode the value for INF_PARKING.PARKCODE
     *
     * @mbggenerated
     */
    public void setParkcode(String parkcode) {
        this.parkcode = parkcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.COMPANYCODE
     *
     * @return the value of INF_PARKING.COMPANYCODE
     *
     * @mbggenerated
     */
    public String getCompanycode() {
        return companycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.COMPANYCODE
     *
     * @param companycode the value for INF_PARKING.COMPANYCODE
     *
     * @mbggenerated
     */
    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PLATE
     *
     * @return the value of INF_PARKING.PLATE
     *
     * @mbggenerated
     */
    public String getPlate() {
        return plate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PLATE
     *
     * @param plate the value for INF_PARKING.PLATE
     *
     * @mbggenerated
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PLATECOLOR
     *
     * @return the value of INF_PARKING.PLATECOLOR
     *
     * @mbggenerated
     */
    public Short getPlatecolor() {
        return platecolor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PLATECOLOR
     *
     * @param platecolor the value for INF_PARKING.PLATECOLOR
     *
     * @mbggenerated
     */
    public void setPlatecolor(Short platecolor) {
        this.platecolor = platecolor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.VEHICLETYPE
     *
     * @return the value of INF_PARKING.VEHICLETYPE
     *
     * @mbggenerated
     */
    public Short getVehicletype() {
        return vehicletype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.VEHICLETYPE
     *
     * @param vehicletype the value for INF_PARKING.VEHICLETYPE
     *
     * @mbggenerated
     */
    public void setVehicletype(Short vehicletype) {
        this.vehicletype = vehicletype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PARKTYPE
     *
     * @return the value of INF_PARKING.PARKTYPE
     *
     * @mbggenerated
     */
    public Short getParktype() {
        return parktype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PARKTYPE
     *
     * @param parktype the value for INF_PARKING.PARKTYPE
     *
     * @mbggenerated
     */
    public void setParktype(Short parktype) {
        this.parktype = parktype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.BERTHCODE
     *
     * @return the value of INF_PARKING.BERTHCODE
     *
     * @mbggenerated
     */
    public String getBerthcode() {
        return berthcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.BERTHCODE
     *
     * @param berthcode the value for INF_PARKING.BERTHCODE
     *
     * @mbggenerated
     */
    public void setBerthcode(String berthcode) {
        this.berthcode = berthcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.INTIME
     *
     * @return the value of INF_PARKING.INTIME
     *
     * @mbggenerated
     */
    public Date getIntime() {
        return intime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.INTIME
     *
     * @param intime the value for INF_PARKING.INTIME
     *
     * @mbggenerated
     */
    public void setIntime(Date intime) {
        this.intime = intime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.OUTTIME
     *
     * @return the value of INF_PARKING.OUTTIME
     *
     * @mbggenerated
     */
    public Date getOuttime() {
        return outtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.OUTTIME
     *
     * @param outtime the value for INF_PARKING.OUTTIME
     *
     * @mbggenerated
     */
    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYSTATUS
     *
     * @return the value of INF_PARKING.PAYSTATUS
     *
     * @mbggenerated
     */
    public Short getPaystatus() {
        return paystatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYSTATUS
     *
     * @param paystatus the value for INF_PARKING.PAYSTATUS
     *
     * @mbggenerated
     */
    public void setPaystatus(Short paystatus) {
        this.paystatus = paystatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.REALPAYCASH
     *
     * @return the value of INF_PARKING.REALPAYCASH
     *
     * @mbggenerated
     */
    public BigDecimal getRealpaycash() {
        return realpaycash;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.REALPAYCASH
     *
     * @param realpaycash the value for INF_PARKING.REALPAYCASH
     *
     * @mbggenerated
     */
    public void setRealpaycash(BigDecimal realpaycash) {
        this.realpaycash = realpaycash;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.MUSTPAYCASH
     *
     * @return the value of INF_PARKING.MUSTPAYCASH
     *
     * @mbggenerated
     */
    public BigDecimal getMustpaycash() {
        return mustpaycash;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.MUSTPAYCASH
     *
     * @param mustpaycash the value for INF_PARKING.MUSTPAYCASH
     *
     * @mbggenerated
     */
    public void setMustpaycash(BigDecimal mustpaycash) {
        this.mustpaycash = mustpaycash;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYTYPE
     *
     * @return the value of INF_PARKING.PAYTYPE
     *
     * @mbggenerated
     */
    public Short getPaytype() {
        return paytype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYTYPE
     *
     * @param paytype the value for INF_PARKING.PAYTYPE
     *
     * @mbggenerated
     */
    public void setPaytype(Short paytype) {
        this.paytype = paytype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.OUTTIME1
     *
     * @return the value of INF_PARKING.OUTTIME1
     *
     * @mbggenerated
     */
    public Date getOuttime1() {
        return outtime1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.OUTTIME1
     *
     * @param outtime1 the value for INF_PARKING.OUTTIME1
     *
     * @mbggenerated
     */
    public void setOuttime1(Date outtime1) {
        this.outtime1 = outtime1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYFEE1
     *
     * @return the value of INF_PARKING.PAYFEE1
     *
     * @mbggenerated
     */
    public BigDecimal getPayfee1() {
        return payfee1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYFEE1
     *
     * @param payfee1 the value for INF_PARKING.PAYFEE1
     *
     * @mbggenerated
     */
    public void setPayfee1(BigDecimal payfee1) {
        this.payfee1 = payfee1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.OUTTIME2
     *
     * @return the value of INF_PARKING.OUTTIME2
     *
     * @mbggenerated
     */
    public Date getOuttime2() {
        return outtime2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.OUTTIME2
     *
     * @param outtime2 the value for INF_PARKING.OUTTIME2
     *
     * @mbggenerated
     */
    public void setOuttime2(Date outtime2) {
        this.outtime2 = outtime2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYFEE2
     *
     * @return the value of INF_PARKING.PAYFEE2
     *
     * @mbggenerated
     */
    public BigDecimal getPayfee2() {
        return payfee2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYFEE2
     *
     * @param payfee2 the value for INF_PARKING.PAYFEE2
     *
     * @mbggenerated
     */
    public void setPayfee2(BigDecimal payfee2) {
        this.payfee2 = payfee2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.OUTTIME3
     *
     * @return the value of INF_PARKING.OUTTIME3
     *
     * @mbggenerated
     */
    public Date getOuttime3() {
        return outtime3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.OUTTIME3
     *
     * @param outtime3 the value for INF_PARKING.OUTTIME3
     *
     * @mbggenerated
     */
    public void setOuttime3(Date outtime3) {
        this.outtime3 = outtime3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYFEE3
     *
     * @return the value of INF_PARKING.PAYFEE3
     *
     * @mbggenerated
     */
    public BigDecimal getPayfee3() {
        return payfee3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYFEE3
     *
     * @param payfee3 the value for INF_PARKING.PAYFEE3
     *
     * @mbggenerated
     */
    public void setPayfee3(BigDecimal payfee3) {
        this.payfee3 = payfee3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.OUTTIME4
     *
     * @return the value of INF_PARKING.OUTTIME4
     *
     * @mbggenerated
     */
    public Date getOuttime4() {
        return outtime4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.OUTTIME4
     *
     * @param outtime4 the value for INF_PARKING.OUTTIME4
     *
     * @mbggenerated
     */
    public void setOuttime4(Date outtime4) {
        this.outtime4 = outtime4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYFEE4
     *
     * @return the value of INF_PARKING.PAYFEE4
     *
     * @mbggenerated
     */
    public BigDecimal getPayfee4() {
        return payfee4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYFEE4
     *
     * @param payfee4 the value for INF_PARKING.PAYFEE4
     *
     * @mbggenerated
     */
    public void setPayfee4(BigDecimal payfee4) {
        this.payfee4 = payfee4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.OUTTIME5
     *
     * @return the value of INF_PARKING.OUTTIME5
     *
     * @mbggenerated
     */
    public Date getOuttime5() {
        return outtime5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.OUTTIME5
     *
     * @param outtime5 the value for INF_PARKING.OUTTIME5
     *
     * @mbggenerated
     */
    public void setOuttime5(Date outtime5) {
        this.outtime5 = outtime5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYFEE5
     *
     * @return the value of INF_PARKING.PAYFEE5
     *
     * @mbggenerated
     */
    public BigDecimal getPayfee5() {
        return payfee5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYFEE5
     *
     * @param payfee5 the value for INF_PARKING.PAYFEE5
     *
     * @mbggenerated
     */
    public void setPayfee5(BigDecimal payfee5) {
        this.payfee5 = payfee5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.OUTTIME6
     *
     * @return the value of INF_PARKING.OUTTIME6
     *
     * @mbggenerated
     */
    public Date getOuttime6() {
        return outtime6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.OUTTIME6
     *
     * @param outtime6 the value for INF_PARKING.OUTTIME6
     *
     * @mbggenerated
     */
    public void setOuttime6(Date outtime6) {
        this.outtime6 = outtime6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYFEE6
     *
     * @return the value of INF_PARKING.PAYFEE6
     *
     * @mbggenerated
     */
    public BigDecimal getPayfee6() {
        return payfee6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYFEE6
     *
     * @param payfee6 the value for INF_PARKING.PAYFEE6
     *
     * @mbggenerated
     */
    public void setPayfee6(BigDecimal payfee6) {
        this.payfee6 = payfee6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.OUTTIME7
     *
     * @return the value of INF_PARKING.OUTTIME7
     *
     * @mbggenerated
     */
    public Date getOuttime7() {
        return outtime7;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.OUTTIME7
     *
     * @param outtime7 the value for INF_PARKING.OUTTIME7
     *
     * @mbggenerated
     */
    public void setOuttime7(Date outtime7) {
        this.outtime7 = outtime7;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYFEE7
     *
     * @return the value of INF_PARKING.PAYFEE7
     *
     * @mbggenerated
     */
    public BigDecimal getPayfee7() {
        return payfee7;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYFEE7
     *
     * @param payfee7 the value for INF_PARKING.PAYFEE7
     *
     * @mbggenerated
     */
    public void setPayfee7(BigDecimal payfee7) {
        this.payfee7 = payfee7;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.OUTTIME8
     *
     * @return the value of INF_PARKING.OUTTIME8
     *
     * @mbggenerated
     */
    public Date getOuttime8() {
        return outtime8;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.OUTTIME8
     *
     * @param outtime8 the value for INF_PARKING.OUTTIME8
     *
     * @mbggenerated
     */
    public void setOuttime8(Date outtime8) {
        this.outtime8 = outtime8;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYFEE8
     *
     * @return the value of INF_PARKING.PAYFEE8
     *
     * @mbggenerated
     */
    public BigDecimal getPayfee8() {
        return payfee8;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYFEE8
     *
     * @param payfee8 the value for INF_PARKING.PAYFEE8
     *
     * @mbggenerated
     */
    public void setPayfee8(BigDecimal payfee8) {
        this.payfee8 = payfee8;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.OUTTIME9
     *
     * @return the value of INF_PARKING.OUTTIME9
     *
     * @mbggenerated
     */
    public Date getOuttime9() {
        return outtime9;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.OUTTIME9
     *
     * @param outtime9 the value for INF_PARKING.OUTTIME9
     *
     * @mbggenerated
     */
    public void setOuttime9(Date outtime9) {
        this.outtime9 = outtime9;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYFEE9
     *
     * @return the value of INF_PARKING.PAYFEE9
     *
     * @mbggenerated
     */
    public BigDecimal getPayfee9() {
        return payfee9;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYFEE9
     *
     * @param payfee9 the value for INF_PARKING.PAYFEE9
     *
     * @mbggenerated
     */
    public void setPayfee9(BigDecimal payfee9) {
        this.payfee9 = payfee9;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.OUTTIME10
     *
     * @return the value of INF_PARKING.OUTTIME10
     *
     * @mbggenerated
     */
    public Date getOuttime10() {
        return outtime10;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.OUTTIME10
     *
     * @param outtime10 the value for INF_PARKING.OUTTIME10
     *
     * @mbggenerated
     */
    public void setOuttime10(Date outtime10) {
        this.outtime10 = outtime10;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PAYFEE10
     *
     * @return the value of INF_PARKING.PAYFEE10
     *
     * @mbggenerated
     */
    public BigDecimal getPayfee10() {
        return payfee10;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PAYFEE10
     *
     * @param payfee10 the value for INF_PARKING.PAYFEE10
     *
     * @mbggenerated
     */
    public void setPayfee10(BigDecimal payfee10) {
        this.payfee10 = payfee10;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.VEHICLEPICIN
     *
     * @return the value of INF_PARKING.VEHICLEPICIN
     *
     * @mbggenerated
     */
    public String getVehiclepicin() {
        return vehiclepicin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.VEHICLEPICIN
     *
     * @param vehiclepicin the value for INF_PARKING.VEHICLEPICIN
     *
     * @mbggenerated
     */
    public void setVehiclepicin(String vehiclepicin) {
        this.vehiclepicin = vehiclepicin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.VEHICLEPICOUT
     *
     * @return the value of INF_PARKING.VEHICLEPICOUT
     *
     * @mbggenerated
     */
    public String getVehiclepicout() {
        return vehiclepicout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.VEHICLEPICOUT
     *
     * @param vehiclepicout the value for INF_PARKING.VEHICLEPICOUT
     *
     * @mbggenerated
     */
    public void setVehiclepicout(String vehiclepicout) {
        this.vehiclepicout = vehiclepicout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.ISPLATFORMUSER
     *
     * @return the value of INF_PARKING.ISPLATFORMUSER
     *
     * @mbggenerated
     */
    public Short getIsplatformuser() {
        return isplatformuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.ISPLATFORMUSER
     *
     * @param isplatformuser the value for INF_PARKING.ISPLATFORMUSER
     *
     * @mbggenerated
     */
    public void setIsplatformuser(Short isplatformuser) {
        this.isplatformuser = isplatformuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PLATFORMUSERINFO
     *
     * @return the value of INF_PARKING.PLATFORMUSERINFO
     *
     * @mbggenerated
     */
    public String getPlatformuserinfo() {
        return platformuserinfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PLATFORMUSERINFO
     *
     * @param platformuserinfo the value for INF_PARKING.PLATFORMUSERINFO
     *
     * @mbggenerated
     */
    public void setPlatformuserinfo(String platformuserinfo) {
        this.platformuserinfo = platformuserinfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.APPAPPLYSTATUS
     *
     * @return the value of INF_PARKING.APPAPPLYSTATUS
     *
     * @mbggenerated
     */
    public BigDecimal getAppapplystatus() {
        return appapplystatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.APPAPPLYSTATUS
     *
     * @param appapplystatus the value for INF_PARKING.APPAPPLYSTATUS
     *
     * @mbggenerated
     */
    public void setAppapplystatus(BigDecimal appapplystatus) {
        this.appapplystatus = appapplystatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.APPAPPLYTIME
     *
     * @return the value of INF_PARKING.APPAPPLYTIME
     *
     * @mbggenerated
     */
    public Date getAppapplytime() {
        return appapplytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.APPAPPLYTIME
     *
     * @param appapplytime the value for INF_PARKING.APPAPPLYTIME
     *
     * @mbggenerated
     */
    public void setAppapplytime(Date appapplytime) {
        this.appapplytime = appapplytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.APPFEETIME
     *
     * @return the value of INF_PARKING.APPFEETIME
     *
     * @mbggenerated
     */
    public Date getAppfeetime() {
        return appfeetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.APPFEETIME
     *
     * @param appfeetime the value for INF_PARKING.APPFEETIME
     *
     * @mbggenerated
     */
    public void setAppfeetime(Date appfeetime) {
        this.appfeetime = appfeetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.APPAPPLYFEE
     *
     * @return the value of INF_PARKING.APPAPPLYFEE
     *
     * @mbggenerated
     */
    public BigDecimal getAppapplyfee() {
        return appapplyfee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.APPAPPLYFEE
     *
     * @param appapplyfee the value for INF_PARKING.APPAPPLYFEE
     *
     * @mbggenerated
     */
    public void setAppapplyfee(BigDecimal appapplyfee) {
        this.appapplyfee = appapplyfee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.APPREALFEE
     *
     * @return the value of INF_PARKING.APPREALFEE
     *
     * @mbggenerated
     */
    public BigDecimal getApprealfee() {
        return apprealfee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.APPREALFEE
     *
     * @param apprealfee the value for INF_PARKING.APPREALFEE
     *
     * @mbggenerated
     */
    public void setApprealfee(BigDecimal apprealfee) {
        this.apprealfee = apprealfee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.APPPAYPLATFORM
     *
     * @return the value of INF_PARKING.APPPAYPLATFORM
     *
     * @mbggenerated
     */
    public String getApppayplatform() {
        return apppayplatform;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.APPPAYPLATFORM
     *
     * @param apppayplatform the value for INF_PARKING.APPPAYPLATFORM
     *
     * @mbggenerated
     */
    public void setApppayplatform(String apppayplatform) {
        this.apppayplatform = apppayplatform;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.APPAPPLYORDER
     *
     * @return the value of INF_PARKING.APPAPPLYORDER
     *
     * @mbggenerated
     */
    public String getAppapplyorder() {
        return appapplyorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.APPAPPLYORDER
     *
     * @param appapplyorder the value for INF_PARKING.APPAPPLYORDER
     *
     * @mbggenerated
     */
    public void setAppapplyorder(String appapplyorder) {
        this.appapplyorder = appapplyorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.PLATFORMFEEORDER
     *
     * @return the value of INF_PARKING.PLATFORMFEEORDER
     *
     * @mbggenerated
     */
    public String getPlatformfeeorder() {
        return platformfeeorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.PLATFORMFEEORDER
     *
     * @param platformfeeorder the value for INF_PARKING.PLATFORMFEEORDER
     *
     * @mbggenerated
     */
    public void setPlatformfeeorder(String platformfeeorder) {
        this.platformfeeorder = platformfeeorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column INF_PARKING.UPDATETIME
     *
     * @return the value of INF_PARKING.UPDATETIME
     *
     * @mbggenerated
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column INF_PARKING.UPDATETIME
     *
     * @param updatetime the value for INF_PARKING.UPDATETIME
     *
     * @mbggenerated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id='" + id + '\'' +
                ", parkcode='" + parkcode + '\'' +
                ", plate='" + plate + '\'' +
                ", platecolor=" + platecolor +
                ", intime=" + intime +
                ", outtime=" + outtime +
                ", outtime1=" + outtime1 +
                ", payfee1=" + payfee1 +
                ", outtime2=" + outtime2 +
                ", payfee2=" + payfee2 +
                ", outtime3=" + outtime3 +
                ", payfee3=" + payfee3 +
                ", outtime4=" + outtime4 +
                ", payfee4=" + payfee4 +
                ", outtime5=" + outtime5 +
                ", payfee5=" + payfee5 +
                ", outtime6=" + outtime6 +
                ", payfee6=" + payfee6 +
                ", outtime7=" + outtime7 +
                ", payfee7=" + payfee7 +
                ", outtime8=" + outtime8 +
                ", payfee8=" + payfee8 +
                ", outtime9=" + outtime9 +
                ", payfee9=" + payfee9 +
                ", outtime10=" + outtime10 +
                ", payfee10=" + payfee10 +
                '}';
    }
}