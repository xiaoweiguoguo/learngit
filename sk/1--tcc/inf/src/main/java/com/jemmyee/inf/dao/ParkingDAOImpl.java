package com.jemmyee.inf.dao;

import com.jemmyee.core.dao.BaseDAOImpl;
import com.jemmyee.inf.entity.Parking;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Administrator on 2017/9/6.
 */
@Repository("parkingDAOImpl")
public class ParkingDAOImpl extends BaseDAOImpl<Parking> implements IParkingDAO {

    protected final Log log = LogFactory.getLog(this.getClass());

    private final String namespace="com.jemmyee.inf.entity.ParkingMapper";

    @SuppressWarnings("unchecked")
    private String mapperPackage = Parking.class.getName().replace("entity", "mapper");

    /**
     * 修改对象 只修改entity不为null的值
     * @param entity
     * @return
     */
    public int updateSelective(Parking entity) {
        return getSqlSession().update(this.mapperPackage+"Mapper.updateByPrimaryKeySelective",entity);
    }
}
