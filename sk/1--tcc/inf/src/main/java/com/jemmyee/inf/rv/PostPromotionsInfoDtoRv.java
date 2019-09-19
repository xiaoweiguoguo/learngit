package com.jemmyee.inf.rv;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：PostPromotionsInfoDtoRv
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-8
 * 编写时间                : 10:13
 * 程序功能（类）描述       ：<p>
 */
public class PostPromotionsInfoDtoRv {
    @ApiModelProperty(value = "减免金额 0代表无减免  默认0")
    private Integer	deduction=0;
    @ApiModelProperty(value = "优惠折扣 0代表无折扣 默认0")
    private Float	discount= Float.valueOf(0);

    public Integer getDeduction() {
        return deduction;
    }

    public void setDeduction(Integer deduction) {
        this.deduction = deduction;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
