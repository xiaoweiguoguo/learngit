package com.jemmyee.inf.dto;

public class WebSeviceCarDto {
    private String bh;//停车场系统唯一编码，由公安交管系统统一派发
    private String mc; //停车场名称  由公安交管系统统一命名
    private String scsj;//上传时间 yyyy-mm-dd hh24:mi:ss\
    private String jccsjid;//进出场数据id 数据唯一标识，由各厂商自行定义
    private String hphm;//号牌号码 例：鄂A12345，没有识别号牌上传“无车牌”
    private String hpzl;//号牌种类 01大型汽车 ：黄底黑字 02小型汽车：蓝底白字 99其他车牌，新能源暂归其他类
    private int fs;//1：进场  2：出场
    private String crkbh;//出入口编号或描述
    private String csys;//车身颜色,由于停车场暂未上传车身颜色，所以先传死值
    private String tp;//过车图片转化成base64字符串 先为空
    private String tztp;//车牌特征图片转化成base64字符串 先为空
    private String tgsj;//通过时间 yyyy-mm-dd hh24:mi:ss
    private String sjzt;//数据状态 01:完整数据，02:图片延迟数据，03:补全图片数据
    private String id;//sjzt值为03补全图片数据时，必须上传id编号（上传图片延迟数据时返回id）

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getScsj() {
        return scsj;
    }

    public void setScsj(String scsj) {
        this.scsj = scsj;
    }

    public String getJccsjid() {
        return jccsjid;
    }

    public void setJccsjid(String jccsjid) {
        this.jccsjid = jccsjid;
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm;
    }

    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) {
        this.hpzl = hpzl;
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }

    public String getCrkbh() {
        return crkbh;
    }

    public void setCrkbh(String crkbh) {
        this.crkbh = crkbh;
    }

    public String getCsys() {
        return csys;
    }

    public void setCsys(String csys) {
        this.csys = csys;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getTztp() {
        return tztp;
    }

    public void setTztp(String tztp) {
        this.tztp = tztp;
    }

    public String getTgsj() {
        return tgsj;
    }

    public void setTgsj(String tgsj) {
        this.tgsj = tgsj;
    }

    public String getSjzt() {
        return sjzt;
    }

    public void setSjzt(String sjzt) {
        this.sjzt = sjzt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

