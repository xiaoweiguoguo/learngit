package com.jemmyee.core.dao;

import com.github.pagehelper.PageInfo;
import com.jemmyee.core.entity.BaseExample;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jemmyee
 **/
public interface IBaseDAO<T> {
    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public T selectByPrimaryKey(Long id);
    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public T selectByPrimaryKey(String id);
    /**
     * 持久化对象
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * 修改对象 使用前请先通过主键查询，再setter要修改的值
     * @param entity
     * @return
     */
    public int  update(T entity);

    /**
     * 通过主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id);

    /**
     * 条件查询数量
     * @param example
     * @return
     */
    public int countByExample(BaseExample example);

    /**
     * 条件查询
     * @param exapmle
     * @return
     */
    public List<T> selectByExample(BaseExample exapmle);

    /**
     * 条件分页查询
     * @param exapmle
     * @param pageSize 每页记录数
     * @param pageNo   起始记录
     * @return
     */
    public PageInfo<T> selectPageByexample(BaseExample exapmle, final Integer pageSize, final Integer pageNo);
}
