package com.jemmyee.inf.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：StatusVo
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-13
 * 编写时间                : 08:31
 * 程序功能（类）描述       ：<p>
 */
public class StatusVo {
    @ApiModelProperty(value = "处理结果 0-受理成功 1-处理失败 2-未知错误")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
