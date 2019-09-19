package com.jemmyee.inf.dao;

import com.jemmyee.core.dao.BaseDAOImpl;
import com.jemmyee.inf.entity.ParkInfo;
import com.jemmyee.inf.entity.Parking;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/6.
 */
@Repository("parkInfoDAOImpl")
public class ParkInfoDAOImpl extends BaseDAOImpl<ParkInfo> implements IParkInfoDAO {

    protected final Log log = LogFactory.getLog(this.getClass());

    private final String namespace="com.jemmyee.inf.entity.ParkInfoMapper";

    @SuppressWarnings("unchecked")
    private String mapperPackage = ParkInfo.class.getName().replace("entity", "mapper");

    /**
     * 修改对象 只修改entity不为null的值
     * @param entity
     * @return
     */
    public int updateSelective(ParkInfo entity) {
        return getSqlSession().update(this.mapperPackage+"Mapper.updateByPrimaryKeySelective",entity);
    }

}
