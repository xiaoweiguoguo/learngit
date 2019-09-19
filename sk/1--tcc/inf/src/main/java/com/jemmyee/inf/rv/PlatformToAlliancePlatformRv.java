package com.jemmyee.inf.rv;

import io.swagger.annotations.ApiModelProperty;

/**
 * 文件名称                ：PlatformToAlliancePlatformRv
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-8
 * 编写时间                : 01:18
 * 程序功能（类）描述       ：平台向联盟平台提交时段收费信息(车辆进入时),联盟平台返回参数
 */
public class PlatformToAlliancePlatformRv {
    @ApiModelProperty(value = "处理结果 0-受理成功 1-处理失败 2-未知错误")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
