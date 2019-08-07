package com.jemmyee.inf.service;

import com.github.pagehelper.PageInfo;
import com.jemmyee.core.entity.BaseExample;
import com.jemmyee.core.service.BaseServiceImpl;
import com.jemmyee.inf.dao.IParkInfoDAO;
import com.jemmyee.inf.entity.ParkInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */
@Service("parkInfoService")
public class ParkInfoServiceImpl extends BaseServiceImpl<ParkInfo> implements IParkInfoService {
    @Autowired
    private IParkInfoDAO parkInfoDAO;

    public ParkInfo selectByPrimaryKey(Long id) {
        return parkInfoDAO.selectByPrimaryKey(id);
    }

    public ParkInfo selectByPrimaryKey(String id) {
        return parkInfoDAO.selectByPrimaryKey(id);
    }

    public int insert(ParkInfo entity) {
        return parkInfoDAO.insert(entity);
    }

    public int update(ParkInfo entity) {
        return parkInfoDAO.update(entity);
    }

    public int updateSelective(ParkInfo entity){return parkInfoDAO.updateSelective(entity);}

    public int deleteByPrimaryKey(Long id) {
        return parkInfoDAO.deleteByPrimaryKey(id);
    }

    public int countByExample(BaseExample example) {
        return parkInfoDAO.countByExample(example);
    }

    public List<ParkInfo> selectByExample(BaseExample exapmle) {
        return parkInfoDAO.selectByExample(exapmle);
    }

    public PageInfo<ParkInfo> selectPageByexample(BaseExample exapmle, Integer pageSize, Integer pageNo) {
        return parkInfoDAO.selectPageByexample(exapmle, pageSize, pageNo);
    }
}
