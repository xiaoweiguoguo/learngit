package com.jemmyee.inf.dao;

import com.jemmyee.core.dao.IBaseDAO;
import com.jemmyee.inf.entity.Parking;

/**
 * Created by Administrator on 2017/9/6.
 */
public interface IParkingDAO extends IBaseDAO<Parking> {

    /**
     * 修改对象 只修改entity不为null的值
     * @param entity
     * @return
     */
    int  updateSelective(Parking entity);
}
