package com.jemmyee.inf.dto;

import java.math.BigDecimal;

public class PaymoneyDto {
    private String plate;//车牌号
    private String code;//停车场编号
    private BigDecimal real_income;//实收金额
    private BigDecimal must_income;//应付金额

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getReal_income() {
        return real_income;
    }

    public void setReal_income(BigDecimal real_income) {
        this.real_income = real_income;
    }

    public BigDecimal getMust_income() {
        return must_income;
    }

    public void setMust_income(BigDecimal must_income) {
        this.must_income = must_income;
    }
}
