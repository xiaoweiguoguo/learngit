package com.jemmyee.core.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jemmyee.core.entity.BaseExample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jemmyee
 **/
public class BaseDAOImpl<T>  extends SqlSessionDaoSupport implements IBaseDAO<T> {

    protected final Log log = LogFactory.getLog(this.getClass());

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     *实体类,对应T
     */
    private Class<T> entityClass;

    public Class<T> getEntityClass() {
        return entityClass;
    }

    private String mapperPackage;

    public String getMapperPackage() {
        return mapperPackage;
    }

    @SuppressWarnings("unchecked")
    public BaseDAOImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        this.mapperPackage = this.entityClass.getName().replace("entity", "mapper");
    }

    public T selectByPrimaryKey(Long id) {
        log.info("selectByPrimaryKey:"+entityClass.getName()+":"+id);
        return getSqlSession().selectOne(this.mapperPackage+"Mapper.selectByPrimaryKey",id);
    }
    public T selectByPrimaryKey(String id) {
        log.info("selectByPrimaryKey:"+entityClass.getName()+":"+id);
        return getSqlSession().selectOne(this.mapperPackage+"Mapper.selectByPrimaryKey",id);
    }
    public int insert(T entity) {
        return getSqlSession().insert(this.mapperPackage+"Mapper.insert",entity);
    }

    public int update(T entity) {
        return getSqlSession().update(this.mapperPackage+"Mapper.updateByPrimaryKey",entity);
    }

    public int deleteByPrimaryKey(Long id) {
        return getSqlSession().delete(this.mapperPackage+"Mapper.deleteByPrimaryKey",id);
    }

    public int countByExample(BaseExample example) {
        return getSqlSession().selectOne(this.mapperPackage+"Mapper.countByExample");
    }

    public List<T> selectByExample(BaseExample exapmle) {
        return getSqlSession().selectList(this.mapperPackage+"Mapper.selectByExample",exapmle);

    }

    public PageInfo<T> selectPageByexample(BaseExample exapmle, Integer pageSize, Integer pageNo)
    {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        return new PageInfo<T>(selectByExample(exapmle));
    }

}
