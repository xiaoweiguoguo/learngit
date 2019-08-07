package com.jemmyee.inf.dto;

public class WebSeviceParkingDto {
    private String bh;//停车场系统唯一编码，由公安交管系统统一派发
    private String mc; //停车场名称  由公安交管系统统一命名
    private int cwzs;//停车场车位总数
    private String ztsjid;//数据唯一标识，由各厂商自行定义
    private String tcczt;//停车场状态 01正常营业 02部分营业 03未营业
    private String scsj;//上传时间 yyyy-mm-dd hh24:mi:ss\
    private int sycws;//停车场剩余车位总数
    private int gdcws;//固定车位：车辆专用停车位，外车辆不可用
    private int sygdcws;//剩余固定车位
    private int lscws;//临时车位：一般停车位，有空余外车辆可以使用
    private int sylscws;//剩余临时车位数

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

    public int getCwzs() {
        return cwzs;
    }

    public void setCwzs(int cwzs) {
        this.cwzs = cwzs;
    }

    public String getZtsjid() {
        return ztsjid;
    }

    public void setZtsjid(String ztsjid) {
        this.ztsjid = ztsjid;
    }

    public String getTcczt() {
        return tcczt;
    }

    public void setTcczt(String tcczt) {
        this.tcczt = tcczt;
    }

    public String getScsj() {
        return scsj;
    }

    public void setScsj(String scsj) {
        this.scsj = scsj;
    }

    public int getSycws() {
        return sycws;
    }

    public void setSycws(int sycws) {
        this.sycws = sycws;
    }

    public int getGdcws() {
        return gdcws;
    }

    public void setGdcws(int gdcws) {
        this.gdcws = gdcws;
    }

    public int getSygdcws() {
        return sygdcws;
    }

    public void setSygdcws(int sygdcws) {
        this.sygdcws = sygdcws;
    }

    public int getLscws() {
        return lscws;
    }

    public void setLscws(int lscws) {
        this.lscws = lscws;
    }

    public int getSylscws() {
        return sylscws;
    }

    public void setSylscws(int sylscws) {
        this.sylscws = sylscws;
    }
}

