package com.jemmyee.inf.controller.downstream;

import com.jemmyee.core.utils.EntityToMap;
import com.jemmyee.core.utils.StringUtil;
import com.jemmyee.core.web.Constants;
import com.jemmyee.core.web.HttpRequest;
import com.jemmyee.core.web.Response;
import com.jemmyee.core.web.ResponseData;
import com.jemmyee.inf.dto.ParkingRecordDto;
import com.jemmyee.inf.dto.PlatformParkInfoDto;
import com.jemmyee.inf.entity.ParkInfo;
import com.jemmyee.inf.entity.Parking;
import com.jemmyee.inf.entity.ParkingExample;
import com.jemmyee.inf.service.IParkInfoService;
import com.jemmyee.inf.service.IParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */
@Api(value="downParkInfo", description="下行--场站管理")
@Controller("DownParkInfoController")
@RequestMapping("/downstream_inf")
public class DownParkInfoController {

    Log log = LogFactory.getLog( this .getClass());
    @Autowired
    private IParkInfoService parkInfoService;

    @Autowired
    private IParkingService parkingService;

    @ApiOperation(value="自建停车场提交停车场基本信息到平台",notes="自建停车场提交停车场基本信息到平台")
    @RequestMapping(value="/send_park_info",method= RequestMethod.POST)
    @ResponseBody
    public Response<String> sendParkInfo(@ModelAttribute ParkInfo bean) {

        ParkInfo parkInfo = parkInfoService.selectByPrimaryKey(bean.getCode());
        if (parkInfo != null) {
            log.info("自建停车场提交停车场基本信息到平台"+ResponseData.MSG_000001+"停车场编号已存在！"+bean.toString());
            return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001, "停车场编号已存在！");
        }
        int i = parkInfoService.insert(bean);
        if (i == 1) {
            PlatformParkInfoDto park = new PlatformParkInfoDto();
            park.setCode(bean.getCode());
            park.setName(bean.getName());
            park.setLat(new BigDecimal(bean.getLat().doubleValue()));
            park.setLng(new BigDecimal(bean.getLng().doubleValue()));
            park.setAddress(bean.getAddress());
            park.setCompanyCode(bean.getCompanycode());
            park.setTotalNum(bean.getTotalnum().intValue());
            park.setPkLotType(bean.getPklottype().intValue());
            park.setPkLotCategory(bean.getPklotcategory().intValue());
            park.setPkLotAttribute(bean.getPklotattribute().intValue());
            park.setPkLotPayRule(bean.getPklotpayrule());
            if(bean.getPklotpic1() !=null){
                park.setPkLotPic1(new File(bean.getPklotpic1()));
            }
            park.setPkLotPic1(new File(bean.getPklotpic1()));
            if(bean.getPklotpic2() !=null){
                park.setPkLotPic2(new File(bean.getPklotpic2()));
            }
            if(bean.getPklotpic3() !=null){
                park.setPkLotPic3(new File(bean.getPklotpic3()));
            }
            park.setDistrictCode(bean.getDistrictCode());
            JSONObject jsonObject = JSONObject.fromObject(
                    HttpRequest.sendPost(Constants.LM_INF_URL1 + "/upstream_inf/pklot_base_info", EntityToMap.ConvertObjToMap(park)));
            if ("000000".equals(jsonObject.get("code"))) {
                log.info("自建停车场提交停车场基本信息到平台"+ResponseData.MSG_000000+bean.toString());
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000);
            }
            log.info("自建停车场提交停车场基本信息到平台"+"写进平台成功，写进联盟失败！"+park.toString());
            return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001);
        } else {
            log.info("自建停车场提交停车场基本信息到平台"+"写进平台已经失败！"+bean.toString());
            return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001);
        }

    }

    @ApiOperation(value="停车场告知平台删除离场车辆再进场所造成的垃圾数据",notes="停车场告知平台删除离场车辆再进场所造成的垃圾数据")
    @RequestMapping(value="/send_to_parkWeb",method= RequestMethod.POST)
    @ResponseBody
    public Response<String> sendParkingdelete(@ModelAttribute ParkingRecordDto bean) {
        //停车记录标识
        if (StringUtil.isNotNullStr(bean.getRecordId())) {
            log.info("停车场告知平台删除离场车辆再进场所造成的垃圾数据"+"请求失败"+"停车场停车记录流水号不能为空");
            return new Response<String>("000001", "停车场停车记录流水号不能为空");
        }
        // 停车场编号
        if (StringUtil.isNotNullStr(bean.getCode())) {
            log.info("停车场告知平台删除离场车辆再进场所造成的垃圾数据"+"请求失败"+"停车场编号不能为空");
            return new Response<String>("000001", "停车场编号");
        }
        //停车场平台编号
        if (StringUtil.isNotNullStr(bean.getPlatformCode())) {
            log.info("停车场告知平台删除离场车辆再进场所造成的垃圾数据"+"请求失败"+"停车场平台编号不能为空");
            return new Response<String>("000001", "停车场平台编号不能为空");
        }
        ParkingExample parkingExample = new ParkingExample();
        parkingExample.or().andIdEqualTo(bean.getRecordId());
        List<Parking> list = parkingService.selectByExample(parkingExample);
        if (list == null && list.size() == 0) {
            log.info("停车场告知平台删除离场车辆再进场所造成的垃圾数据"+"请求失败"+"无记录"+bean);
            return new Response<String>(ResponseData.CODE_100002, ResponseData.MSG_100002);
        }else{
            Long id=new Long(bean.getRecordId());
            int deleteParking= parkInfoService.deleteByPrimaryKey(id);
            if(deleteParking>0){
                log.info("停车场告知平台删除离场车辆再进场所造成的垃圾数据"+"请求成功"+"平台成功删除"+bean);
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000);
            }else{
                log.info("停车场告知平台删除离场车辆再进场所造成的垃圾数据"+"请求成功"+"但是平台删除失败"+bean);
                return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001);
            }
        }
    }
}
