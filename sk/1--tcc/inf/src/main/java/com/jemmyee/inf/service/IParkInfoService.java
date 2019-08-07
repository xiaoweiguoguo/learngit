package com.jemmyee.inf.service;

import com.jemmyee.core.service.IBaseService;
import com.jemmyee.inf.entity.ParkInfo;
import com.jemmyee.inf.entity.Parking;

/**
 * Created by Administrator on 2017/9/6.
 */
public interface IParkInfoService extends IBaseService<ParkInfo> {
    int  updateSelective(ParkInfo entity);
}
