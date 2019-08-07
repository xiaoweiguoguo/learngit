package com.jemmyee.inf.controller.upstream;

import com.jemmyee.core.WebService.ParkingPortType;
import com.jemmyee.core.WebService.Parkinginfo;
import com.jemmyee.core.utils.CommonUtils;
import com.jemmyee.core.utils.EntityToMap;
import com.jemmyee.core.utils.StringUtil;
import com.jemmyee.core.web.Constants;
import com.jemmyee.core.web.HttpRequest;
import com.jemmyee.core.web.Response;
import com.jemmyee.core.web.ResponseData;
import com.jemmyee.inf.dto.*;
import com.jemmyee.inf.entity.Parking;
import com.jemmyee.inf.entity.ParkingExample;
import com.jemmyee.inf.service.IParkingService;
import com.jemmyee.inf.vo.StatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.Date;

import java.util.List;


/**
 * Created by Administrator on 2017/9/6.
 */
@Api(value="upParking", description="上行--停车记录")
@Controller("UpParkingController")
@RequestMapping("/upstream_inf")
public class UpParkingController{

    @Autowired
    private IParkingService parkingService;
    Log log = LogFactory.getLog( this .getClass());
    @ApiOperation(value = "停车场向平台发送车辆未来10个小时段的收费(车辆进入时)",
            notes = "停车场向平台发送车辆未来10个小时段的收费(车辆进入时)")
    @RequestMapping(value = "ParkingToPlatform", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 700001, message = "停车场停车记录流水号不能为空"),
            @ApiResponse(code = 700002, message = "停车场编号不能为空"),
            @ApiResponse(code = 700003, message = "停车平台编号不能为空"),
            @ApiResponse(code = 700004, message = "车牌号不能为空"),
            @ApiResponse(code = 700005, message = "车牌颜色不能为空"),
            @ApiResponse(code = 700006, message = "时间格式为yyyyMMddHHmmss"),
            @ApiResponse(code = 700007, message = "应付费用不能为空"),
            @ApiResponse(code = 000000, message = "请求成功"),
            @ApiResponse(code = 000001, message = "请求失败"),
            @ApiResponse(code = 000001, message = "未知错误"),
    })
    @ResponseBody
    public Response<StatusVo> ParkingToPlatform(@RequestBody PostParkingFeeDto bean) {
        //        停车记录标识
        if (StringUtil.isNotNullStr(bean.getRecordId())) {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"停车记录流水号不能为空"+bean.toString());
            return new Response<StatusVo>("700001", "停车场停车记录流水号不能为空");
        }
        //停车场编号
        if (StringUtil.isNotNullStr(bean.getCode())) {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"停车场编号不能为空"+bean.toString());
            return new Response<StatusVo>("700002", "停车场编号不能为空");
        }
        //停车平台编号
        if (StringUtil.isNotNullStr(bean.getCompanyCode())) {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"停车平台编号不能为空"+bean.toString());
            return new Response<StatusVo>("700003", "停车平台编号不能为空");
        }
        //车牌号
        if (StringUtil.isNotNullStr(bean.getPlate())) {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"车牌号不能为空"+bean.toString());
            return new Response<StatusVo>("700004", "车牌号不能为空");
        }
        //        //车牌颜色 0-蓝 1-黄 2-白 3-黑
        //        if (bean.getPlateColor() != 0 || bean.getPlateColor() != 1) {
        //            return new Response<String>("700005", "车牌颜色不能为空", null);
        //        }
        //进场时间
        if (CommonUtils.StringIfDateFormat(bean.getInTime(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS)) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"时间格式为yyyyMMddHHmmss"+bean.toString());
            return new Response<StatusVo>("700006", "时间格式为yyyyMMddHHmmss");
        }
        //未来出场时间1
        if (CommonUtils.StringIfDateFormat(bean.getOutTime1(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS)) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"时间格式为yyyyMMddHHmmss"+bean.toString());
            return new Response<StatusVo>("700006", "时间格式为yyyyMMddHHmmss");
        }
        //应付费用1
        if (!bean.getPayFee1().equals("") || bean.getPayFee1() != null) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"应付费用不能为空"+bean.toString());
            return new Response<StatusVo>("700007", "应付费用不能为空");
        }
        //未来出场时间2
        if (CommonUtils.StringIfDateFormat(bean.getOutTime2(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS)) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"时间格式为yyyyMMddHHmmss"+bean.toString());
            return new Response<StatusVo>("700006", "时间格式为yyyyMMddHHmmss");
        }
        //应付费用2
        if (!bean.getPayFee2().equals("") || bean.getPayFee2() != null) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"应付费用不能为空"+bean.toString());
            return new Response<StatusVo>("700007", "应付费用不能为空");
        }
        //未来出场时间3
        if (CommonUtils.StringIfDateFormat(bean.getOutTime3(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS)) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"时间格式为yyyyMMddHHmmss"+bean.toString());
            return new Response<StatusVo>("700006", "时间格式为yyyyMMddHHmmss");
        }
        //应付费用3
        if (!bean.getPayFee3().equals("") || bean.getPayFee3() != null) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"应付费用不能为空"+bean.toString());
            return new Response<StatusVo>("700007", "应付费用不能为空");
        }
        //未来出场时间4
        if (CommonUtils.StringIfDateFormat(bean.getOutTime4(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS)) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"时间格式为yyyyMMddHHmmss"+bean.toString());
            return new Response<StatusVo>("700006", "时间格式为yyyyMMddHHmmss");
        }
        //应付费用4
        if (!bean.getPayFee4().equals("") || bean.getPayFee4() != null) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"应付费用不能为空"+bean.toString());
            return new Response<StatusVo>("700007", "应付费用不能为空");
        }
        //未来出场时间5
        if (CommonUtils.StringIfDateFormat(bean.getOutTime5(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS)) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"时间格式为yyyyMMddHHmmss"+bean.toString());
            return new Response<StatusVo>("700006", "时间格式为yyyyMMddHHmmss");
        }
        //应付费用5
        if (!bean.getPayFee5().equals("") || bean.getPayFee5() != null) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"应付费用不能为空"+bean.toString());
            return new Response<StatusVo>("700007", "应付费用不能为空");
        }
        //未来出场时间6
        if (CommonUtils.StringIfDateFormat(bean.getOutTime6(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS)) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"时间格式为yyyyMMddHHmmss"+bean.toString());
            return new Response<StatusVo>("700006", "时间格式为yyyyMMddHHmmss");
        }
        //应付费用6
        if (!bean.getPayFee6().equals("") || bean.getPayFee6() != null) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"应付费用不能为空"+bean.toString());
            return new Response<StatusVo>("700007", "应付费用不能为空");
        }
        //未来出场时间7
        if (CommonUtils.StringIfDateFormat(bean.getOutTime7(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS)) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"时间格式为yyyyMMddHHmmss"+bean.toString());
            return new Response<StatusVo>("700006", "时间格式为yyyyMMddHHmmss");
        }
        //应付费用7
        if (!bean.getPayFee7().equals("") || bean.getPayFee7() != null) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"应付费用不能为空"+bean.toString());
            return new Response<StatusVo>("700007", "应付费用不能为空");
        }
        //未来出场时间8
        if (CommonUtils.StringIfDateFormat(bean.getOutTime8(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS)) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"时间格式为yyyyMMddHHmmss"+bean.toString());
            return new Response<StatusVo>("700006", "时间格式为yyyyMMddHHmmss");
        }
        //应付费用8
        if (!bean.getPayFee8().equals("") || bean.getPayFee8() != null) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"应付费用不能为空"+bean.toString());
            return new Response<StatusVo>("700007", "应付费用不能为空");
        }
        //未来出场时间9
        if (CommonUtils.StringIfDateFormat(bean.getOutTime9(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS)) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"时间格式为yyyyMMddHHmmss"+bean.toString());
            return new Response<StatusVo>("700006", "时间格式为yyyyMMddHHmmss");
        }
        //应付费用9
        if (!bean.getPayFee9().equals("") || bean.getPayFee9() != null) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"应付费用不能为空"+bean.toString());
            return new Response<StatusVo>("700007", "应付费用不能为空");
        }
        //未来出场时间10
        if (CommonUtils.StringIfDateFormat(bean.getOutTime10(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS)) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"时间格式为yyyyMMddHHmmss"+bean.toString());
            return new Response<StatusVo>("700006", "时间格式为yyyyMMddHHmmss");
        }
        //应付费用10
        if (!bean.getPayFee10().equals("") || bean.getPayFee10() != null) {

        } else {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+"请求失败"+"应付费用不能为空"+bean.toString());
            return new Response<StatusVo>("700007", "应付费用不能为空");
        }

        ParkingExample parkingExample = new ParkingExample();
        parkingExample.or().andIdEqualTo(bean.getRecordId());
        List<Parking> list = parkingService.selectByExample(parkingExample);
        if (list == null && list.size() == 0) {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+ResponseData.MSG_100002+bean.toString());
            return new Response<StatusVo>(ResponseData.CODE_100002, ResponseData.MSG_100002);
        }
        //修改bean字段不为null的值
        Parking parking = new Parking();
        //停车记录标识
        parking.setId(bean.getRecordId());
        //停车场编号
        parking.setParkcode(bean.getCode());
        //停车平台编号
        parking.setCompanycode(bean.getCompanyCode());
        //车牌号
        parking.setPlate(bean.getPlate());
        //车牌颜色 0-蓝 1-黄 2-白 3-黑
        parking.setPlatecolor(Short.valueOf(bean.getPlateColor().toString()));
        //进场时间
        parking.setIntime(CommonUtils.parseStringToDateWithFormat(bean.getInTime(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //未来出场时间1
        parking.setOuttime1(CommonUtils.parseStringToDateWithFormat(bean.getOutTime1(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //应付费用1
        parking.setPayfee1(BigDecimal.valueOf(Double.valueOf(bean.getPayFee1())));
        //未来出场时间2
        parking.setOuttime2(CommonUtils.parseStringToDateWithFormat(bean.getOutTime2(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //应付费用2
        parking.setPayfee2(BigDecimal.valueOf(Double.valueOf(bean.getPayFee2())));
        //未来出场时间3
        parking.setOuttime3(CommonUtils.parseStringToDateWithFormat(bean.getOutTime3(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //应付费用3
        parking.setPayfee3(BigDecimal.valueOf(Double.valueOf(bean.getPayFee3())));
        //未来出场时间4
        parking.setOuttime4(CommonUtils.parseStringToDateWithFormat(bean.getOutTime4(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //应付费用4
        parking.setPayfee4(BigDecimal.valueOf(Double.valueOf(bean.getPayFee4())));
        //未来出场时间5
        parking.setOuttime5(CommonUtils.parseStringToDateWithFormat(bean.getOutTime5(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //应付费用5
        parking.setPayfee5(BigDecimal.valueOf(Double.valueOf(bean.getPayFee5())));
        //未来出场时间6
        parking.setOuttime6(CommonUtils.parseStringToDateWithFormat(bean.getOutTime6(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //应付费用6
        parking.setPayfee6(BigDecimal.valueOf(Double.valueOf(bean.getPayFee6())));
        //未来出场时间7
        parking.setOuttime7(CommonUtils.parseStringToDateWithFormat(bean.getOutTime7(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //应付费用7
        parking.setPayfee7(BigDecimal.valueOf(Double.valueOf(bean.getPayFee7())));
        //未来出场时间8
        parking.setOuttime8(CommonUtils.parseStringToDateWithFormat(bean.getOutTime8(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //应付费用8
        parking.setPayfee8(BigDecimal.valueOf(Double.valueOf(bean.getPayFee8())));
        //未来出场时间9
        parking.setOuttime9(CommonUtils.parseStringToDateWithFormat(bean.getOutTime9(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //应付费用9
        parking.setPayfee9(BigDecimal.valueOf(Double.valueOf(bean.getPayFee9())));
        //未来出场时间10
        parking.setOuttime10(CommonUtils.parseStringToDateWithFormat(bean.getOutTime10(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //应付费用10
        parking.setPayfee10(BigDecimal.valueOf(Double.valueOf(bean.getPayFee10())));
        parking.setPaystatus((short) 0);
        StatusVo statusVo = new StatusVo();
        if (parking != null && list.size() > 0) {
            int a = parkingService.updateSelective(parking);
            statusVo.setStatus(0);
            if (a == 0) {
                statusVo.setStatus(1);
                log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+ResponseData.MSG_000001+parking.toString());
                return new Response<StatusVo>(ResponseData.CODE_000001, ResponseData.MSG_000001, statusVo);
            }
        }
        JSONObject jsonObject = JSONObject.fromObject(HttpRequest.sendPost2(Constants.LM_INF_URL2 + "/PostParkingFee",
                EntityToMap.ConvertObjToMap(bean)));
        //先用做定时清理，后期改回来
        if (! "00".equals(jsonObject.get("code"))) {
            log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+ResponseData.MSG_200001+parking.toString());
            return new Response<StatusVo>(ResponseData.CODE_200001, ResponseData.MSG_200001);
        }
        log.info("停车场向平台发送车辆未来10个小时段的收费(车辆进入时)"+ResponseData.MSG_200002+parking.toString());
        return new Response<StatusVo>(ResponseData.CODE_200002, ResponseData.MSG_200002, statusVo);
    }

    @ApiOperation(value="停车场向平台推送停车场记录",notes="停车场向平台推送停车场记录")
    @RequestMapping(value="/send_parking_record",method= RequestMethod.POST)
    @ResponseBody
    public Response<SendRecordDto> setParkingRecord(@ModelAttribute SendRecordDto bean) {

        Parking parking1 = parkingService.selectByPrimaryKey(bean.getRecordId());
        if (parking1 != null) {
            log.info("停车场向平台推送停车场记录"+ResponseData.MSG_000006+bean.toString());
            return new Response<SendRecordDto>(ResponseData.CODE_000006, ResponseData.MSG_000006);
        }

        Parking parking = new Parking();
        parking.setId(bean.getRecordId());
        parking.setParkcode(bean.getCode());
        parking.setCompanycode(bean.getCompanyCode());
        if(bean.getPlate() != null && ! ("").equals(bean.getPlate().trim()))
        {
            parking.setPlate(bean.getPlate().trim());
        }else{
            log.info("停车场向平台推送停车场记录车牌不能为空"+bean.getPlate());
            return new Response<SendRecordDto>(ResponseData.CODE_400001, ResponseData.MSG_400001);
        }
        if (bean.getPlateColor() != null && !("").equals(bean.getPlateColor())) {
            parking.setPlatecolor(bean.getPlateColor().shortValue());
        }
        if (bean.getVehicleType() != null && !("").equals(bean.getVehicleType())) {
            parking.setVehicletype(bean.getVehicleType().shortValue());
        }
        if (bean.getInTime() != null && !("").equals(bean.getInTime())) {
            parking.setIntime(CommonUtils.parseStringToDateWithFormat(bean.getInTime(),"yyyyMMddHHmmss"));
        }
        if (bean.getOutTime() != null && !("").equals(bean.getOutTime())) {
            parking.setOuttime(CommonUtils.parseStringToDateWithFormat(bean.getOutTime(),"yyyyMMddHHmmss"));
        }
        if(bean.getCartype() !=null && !("").equals(bean.getCartype())){
            parking.setCartype(bean.getCartype());
        }
        parking.setVehiclepicin(bean.getVehiclePicIn1());
        parking.setVehiclepicout(bean.getVehiclePicOut1());
        parking.setPaystatus((short) 2);

        int i = parkingService.insert(parking);

        if (i > 0) {
            //通知平台
            JSONObject jsonObject =JSONObject.fromObject(HttpRequest.sendPost(Constants.LM_INF_URL1 + "/upstream_inf/parking_notice_in",
                    EntityToMap.ConvertObjToMap(bean)));
            if (!"000000".equals(jsonObject.get("code"))) {
                log.info("停车场向平台推送停车场记录"+ResponseData.MSG_000001+bean.toString());
                return new Response<SendRecordDto>(ResponseData.CODE_000001, ResponseData.MSG_000001);
            }
            log.info("停车场向平台推送停车场记录"+ResponseData.MSG_000000+bean.toString());
            return new Response<SendRecordDto>(ResponseData.CODE_000000, ResponseData.MSG_000000);
        } else {
            log.info("停车场向平台推送停车场记录"+ResponseData.MSG_000001+bean.toString());
            return new Response<SendRecordDto>(ResponseData.CODE_000001, ResponseData.MSG_000001, null);
        }
    }
    //测试公安局车辆进出WebService
    public static void main(String[] args){
        String xtlb="01";
        String jkxlh="B07F9031FFA8370F24266824118C9207";
//        Map mapHead = new HashMap<String, String>();
//        mapHead.put("bh","420100_153196949468951");//停车场系统唯一编码，由公安交管系统统一派发
//        mapHead.put("mc","城投测试");//由公安交管系统统一命名
//        mapHead.put("scsj","2018-07-20 14:25:00");//上传时间 yyyy-mm-dd hh24:mi:ss
//        mapHead.put("version","1.0");//版本号
//        Map mapData=new HashMap<String, String>();
//        mapData.put("jccsjid","1110000111");//数据唯一标识，由各厂商自行定义
//        mapData.put("hphm","鄂A96T3N");//例：鄂A12345，没有识别号牌上传“无车牌”
//        mapData.put("hpzl","02");//号牌种类 01大型汽车 ：黄底黑字 02小型汽车：蓝底白字 99其他车牌，新能源暂归其他类
//        mapData.put("fs","01");//1：进场  2：出场
//        mapData.put("crkbh","01");//出入口编号或描述
//        mapData.put("csys","A");//车身颜色,由于停车场暂未上传车身颜色，所以先传死值
//        mapData.put("tp","");//过车图片转化成base64字符串 先为空
//        mapData.put("tztp","");//车牌特征图片转化成base64字符串 先为空
//        mapData.put("tgsj","2018-07-20 14:25:00");//通过时间 yyyy-mm-dd hh24:mi:ss
//        mapData.put("sjzt","01");//数据状态 01:完整数据，02:图片延迟数据，03:补全图片数据
//        mapData.put("id","");//sjzt值为03补全图片数据时，必须上传id编号（上传图片延迟数据时返回id）
//        Map map=new HashMap<String, Map<String,String>>();
//        map.put("head",mapHead);
//        map.put("data",mapData);
        WebSeviceCarDto webSeviceDto =new WebSeviceCarDto();
        webSeviceDto.setBh("420100_153196949468951");
        webSeviceDto.setMc("城投测试");
        webSeviceDto.setScsj("2018-07-20 14:25:00");
        webSeviceDto.setJccsjid("1110000111");
        webSeviceDto.setHphm("鄂A96T3N");
        webSeviceDto.setHpzl("02");
        webSeviceDto.setFs(1);
        webSeviceDto.setCrkbh("01");
        webSeviceDto.setCsys("A");
        webSeviceDto.setTgsj("2018-07-20 14:25:00");
        webSeviceDto.setSjzt("01");
        String xmlString=
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<xml>" +
                            "<head>"+
                                "<bh>"+webSeviceDto.getBh()+"</bh>"+
                                "<mc>"+webSeviceDto.getMc()+"</mc>"+
                                "<scsj>"+webSeviceDto.getScsj()+"</scsj>"+
                                "<version>1.0</version>"
                            +"</head>"+
                            "<data>"+
                                "<jccsjid>"+webSeviceDto.getJccsjid()+"</jccsjid>"+
                                "<hphm>"+webSeviceDto.getHphm()+"</hphm>"+
                                "<hpzl>"+webSeviceDto.getHpzl()+"</hpzl>"+
                                "<fs>"+webSeviceDto.getFs()+"</fs>"+
                                "<crkbh>"+webSeviceDto.getCrkbh()+"</crkbh>"+
                                "<csys>"+webSeviceDto.getCsys()+"</csys>"+
                                "<tp></tp>"+
                                "<tztp></tztp>"+
                                "<tgsj>"+webSeviceDto.getTgsj()+"</tgsj>"+
                                "<sjzt>"+webSeviceDto.getSjzt()+"</sjzt>"+
                                "<id></id>"
                            +"</data>"
                        +"</xml>";
        System.out.println(xmlString);
        com.jemmyee.core.WebService.Parking parking=new com.jemmyee.core.WebService.Parking();
        ParkingPortType parkingPortType=parking.getParkingHttpPort();
        String KK= parkingPortType.parkinginfo(xtlb,jkxlh,xmlString);
        System.out.println(KK);
    }
    //测出公安局每两分钟上传泊位数Webservice
//    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
//        String xtlb="02";
//        String jkxlh="B07F9031FFA8370F24266824118C9207";
//        WebSeviceParkingDto webSeviceParkingDto=new WebSeviceParkingDto();
//        webSeviceParkingDto.setBh("420100_153196949468951");
//        webSeviceParkingDto.setMc("城投测试");
//        webSeviceParkingDto.setScsj("2018-07-20 14:25:00");
//        webSeviceParkingDto.setCwzs(720);
//        webSeviceParkingDto.setZtsjid("06");
//        webSeviceParkingDto.setTcczt("01");
//        webSeviceParkingDto.setSycws(450);
//        webSeviceParkingDto.setGdcws(0);
//        webSeviceParkingDto.setSygdcws(0);
//        webSeviceParkingDto.setLscws(0);
//        webSeviceParkingDto.setSylscws(0);
//                String xmlString=
//                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
//                        "<xml>" +
//                            "<head>"+
//                                "<bh>"+webSeviceParkingDto.getBh()+"</bh>"+
//                                "<mc>"+webSeviceParkingDto.getMc()+"</mc>"+
//                                "<cwzs>"+webSeviceParkingDto.getCwzs()+"</cwzs>"+
//                                "<version>1.0</version>"
//                            +"</head>"+
//                            "<data>"+
//                                "<ztsjid>"+webSeviceParkingDto.getZtsjid()+"</ztsjid>"+
//                                "<tcczt>"+webSeviceParkingDto.getTcczt()+"</tcczt>"+
//                                "<scsj>"+webSeviceParkingDto.getScsj()+"</scsj>"+
//                                "<sycws>"+webSeviceParkingDto.getSycws()+"</sycws>"+
//                                "<gdcws>"+webSeviceParkingDto.getGdcws()+"</gdcws>"+
//                                "<sygdcws>"+webSeviceParkingDto.getSygdcws()+"</sygdcws>"+
//                                "<lscws>"+webSeviceParkingDto.getLscws()+"</lscws>"+
//                                "<sylscws>"+webSeviceParkingDto.getSylscws()+"</sylscws>"
//                            +"</data>"
//                        +"</xml>";
//        System.out.println(xmlString);
//        com.jemmyee.core.WebService.Parking parking=new com.jemmyee.core.WebService.Parking();
//        ParkingPortType parkingPortType=parking.getParkingHttpPort();
//        String KK= parkingPortType.parkinginfo(xtlb,jkxlh,xmlString);
////        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
////        DocumentBuilder db = dbf.newDocumentBuilder();
////        Document document = db.parse(KK);
//        System.out.println(KK);
//// 字符串转XML
//        Document doc = CommonUtils.StringTOXml(KK);
//        String nodePath = "/xml/response/result";
//        String nodeValue = CommonUtils.getNodeValue(doc, nodePath);
//        System.out.println(nodeValue);
//    }

    @ApiOperation(value="停车场向平台更新停车记录状态",notes="停车场向平台更新停车记录状态")
    @RequestMapping(value="/send_parking_record_update",method= RequestMethod.POST)
    @ResponseBody
    public Response<Parking> updateParkingRecord(@ModelAttribute ParkingStatusDto bean){
        ParkingExample parkingExample = new ParkingExample();
        parkingExample.or().andIdEqualTo(bean.getId());
        List<Parking> list = parkingService.selectByExample(parkingExample);
        if (list == null && list.size() ==0)
            return new Response<Parking>(ResponseData.CODE_100002, ResponseData.MSG_100002);
        //修改bean字段不为null的值
        Parking parking = new Parking();
        parking.setId(bean.getId());
        parking.setParkcode(bean.getParkcode());
        parking.setCompanycode(bean.getCompanycode());
        parking.setPlate(bean.getPlate());
        parking.setPlatecolor(bean.getPlatecolor());
        parking.setVehicletype(bean.getVehicletype());
        parking.setParktype(bean.getParktype());
        parking.setBerthcode(bean.getBerthcode());
        if (bean.getIntime() != null && !("").equals(bean.getIntime())) {
            parking.setIntime(CommonUtils.parseStringToDateWithFormat(bean.getIntime(),CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        }
        if (bean.getOuttime() != null && !("").equals(bean.getOuttime())) {
            parking.setOuttime(CommonUtils.parseStringToDateWithFormat(bean.getOuttime(),CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        }
        parking.setPaystatus(bean.getPaystatus());
        parking.setRealpaycash(bean.getRealpaycash());
        parking.setMustpaycash(bean.getMustpaycash());
        parking.setPaytype(bean.getPaytype());
        parking.setVehiclepicin(bean.getVehiclepicin());
        parking.setVehiclepicout(bean.getVehiclepicout());
        parking.setIsplatformuser(bean.getIsplatformuser());
        parking.setPlatformuserinfo(bean.getPlatformuserinfo());
        parking.setAppapplystatus(bean.getAppapplystatus());
        if (bean.getAppapplytime() != null && !("").equals(bean.getAppapplytime())) {
            parking.setAppapplytime(CommonUtils.parseStringToDateWithFormat(bean.getAppapplytime(),CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        }
        if (bean.getAppfeetime() != null && !("").equals(bean.getAppfeetime())) {
            parking.setAppfeetime(CommonUtils.parseStringToDateWithFormat(bean.getAppfeetime(),CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        }
        parking.setAppapplyfee(bean.getAppapplyfee());
        parking.setApprealfee(bean.getApprealfee());
        parking.setApppayplatform(bean.getApppayplatform());
        parking.setAppapplyorder(bean.getAppapplyorder());
        parking.setPlatformfeeorder(bean.getPlatformfeeorder());
        parking.setUpdatetime(new Date());
        parking.setCartype(bean.getCartype());
        int i = parkingService.updateSelective(parking);
        if (i > 0) {
            log.info("停车场向平台更新停车记录状态"+ResponseData.MSG_000000+parking.toString());
            return new Response<Parking>(ResponseData.CODE_000000, ResponseData.MSG_000000, parking);
        } else {
            log.info("停车场向平台更新停车记录状态"+ResponseData.MSG_000001);
            return new Response<Parking>(ResponseData.CODE_000001, ResponseData.MSG_000001);
        }
    }

    @ApiOperation(value = "获取联盟token",
            notes = "获取联盟token")
    @RequestMapping(value = "postTokencode", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 000000, message = " 成功"),
            @ApiResponse(code = 010103, message = "运营公司编号错误"),
            @ApiResponse(code = 010101, message = "验签失败")
    })
    @ResponseBody
    public String postTokencode(@ModelAttribute PostTokenCodeDto bean) {
        if (bean.getAccount() == null || bean.getAccount().equals("")) {
            log.info("获取联盟token"+"运营平台编号错误");
            return "运营平台编号错误！";
        }
        String sig=bean.getAccount()+bean.getSignature()+bean.getTimestamp();
        bean.setSignature(getSha1(sig));
        JSONObject jsonObject = JSONObject.fromObject(
                HttpRequest.sendGet(Constants.LM_INF_URL3 + "/sp-platpi-wh/token", EntityToMap.ConvertObjToMap(bean)));
        if ("000000".equals(jsonObject.get("code"))) {
            String toKen= jsonObject.get("data").toString();
            toKen =toKen.substring(10,50);
            log.info("获取联盟token"+toKen);
            return toKen;
        }
        log.info("获取联盟token"+"请求失败");
        return "请求失败";
    }
    //SHA1加密
    public static String getSha1(String str){
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
}
