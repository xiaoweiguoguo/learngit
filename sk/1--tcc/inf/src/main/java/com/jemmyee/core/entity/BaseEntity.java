package com.jemmyee.core.entity;

/**
 * ${DESCRIPTION}
 *
 * @author jemmyee
 **/
public class BaseEntity {

    public Integer pageSize;//每页大小  分页查询用

    public Integer pageNo;//当前页码  分页查询用

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
