package com.jemmyee.inf.service;

import com.github.pagehelper.PageInfo;
import com.jemmyee.core.entity.BaseExample;
import com.jemmyee.core.service.BaseServiceImpl;
import com.jemmyee.inf.dao.IParkingDAO;
import com.jemmyee.inf.entity.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */
@Service("parkingService")
public class ParkingServiceImpl extends BaseServiceImpl<Parking> implements IParkingService {
    @Autowired
    private IParkingDAO parkingDAO;

    public Parking selectByPrimaryKey(Long id) {
        return parkingDAO.selectByPrimaryKey(id);
    }

    public Parking selectByPrimaryKey(String id) {
        return parkingDAO.selectByPrimaryKey(id);
    }

    public int insert(Parking entity) {
        return parkingDAO.insert(entity);
    }

    public int update(Parking entity) {
        return parkingDAO.update(entity);
    }

    public int  updateSelective(Parking entity) {
        return parkingDAO.updateSelective(entity);
    }

    public int deleteByPrimaryKey(Long id) {
        return parkingDAO.deleteByPrimaryKey(id);
    }

    public int countByExample(BaseExample example) {
        return parkingDAO.countByExample(example);
    }

    public List<Parking> selectByExample(BaseExample exapmle) {
        return parkingDAO.selectByExample(exapmle);
    }

    public PageInfo<Parking> selectPageByexample(BaseExample exapmle, Integer pageSize, Integer pageNo) {
        return parkingDAO.selectPageByexample(exapmle, pageSize, pageNo);
    }
}
