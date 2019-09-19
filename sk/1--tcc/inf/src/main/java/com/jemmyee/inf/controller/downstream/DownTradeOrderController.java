package com.jemmyee.inf.controller.downstream;

import com.jemmyee.core.connect.DBConnection;
import com.jemmyee.core.utils.CommonUtils;
import com.jemmyee.core.utils.EJTRequest;
import com.jemmyee.core.utils.EntityToMap;
import com.jemmyee.core.utils.StringUtil;
import com.jemmyee.core.web.Constants;
import com.jemmyee.core.web.HttpRequest;
import com.jemmyee.core.web.Response;
import com.jemmyee.core.web.ResponseData;
import com.jemmyee.inf.dto.*;
import com.jemmyee.inf.entity.*;
import com.jemmyee.inf.service.IAccountService;
import com.jemmyee.inf.service.IParkInfoService;
import com.jemmyee.inf.service.IParkingService;
import com.jemmyee.inf.vo.ParkingFeeVo;
import com.jemmyee.inf.vo.StatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/6.
 */
@Api(value="downTradeOrder", description="下行--交易订单")
@Controller("DownTradeOrderController")
@RequestMapping("/downstream_inf")
public class DownTradeOrderController {
    Log log = LogFactory.getLog( this .getClass());
    @Autowired
    private IParkingService parkingService;
    @Autowired
    private IParkInfoService parkInfoService;
    @Autowired
    private IAccountService accountService;


    @ApiOperation(value = "平台向停车场推送停车记录中的车是否自动付费",
            notes = "平台向停车场推送停车记录中的车是否自动付费")
    @RequestMapping(value = "AllianceWhetherFeePlatform", method = RequestMethod.POST)
    @ResponseBody
    public Response<String> AllianceWhetherFeePlatform(@ModelAttribute PostCarAutoPayInfoDto bean) {
        if(StringUtil.isNotNullStr(bean.getRecordId())){
            log.info("平台向停车场推送停车记录中的车是否自动付费"+"请求失败"+"停车记录流水号不能为空"+bean.toString());
            return new Response<String>("900001", "停车记录流水号不能为空");
        }
        if(StringUtil.isNotNullStr(bean.getCompanyCode())){
            log.info("平台向停车场推送停车记录中的车是否自动付费"+"请求失败"+"停车平台编号不能为空"+bean.toString());
            return new Response<String>("900002", "停车平台编号不能为空");
        }
        if(StringUtil.isNotNullStr(bean.getCode())){
            log.info("平台向停车场推送停车记录中的车是否自动付费"+"请求失败"+"停车场编号不能为空"+bean.toString());
            return new Response<String>("900004", "停车场编号不能为空");
        }
        if(StringUtil.isNotNullStr(bean.getPlate())){
            log.info("平台向停车场推送停车记录中的车是否自动付费"+"请求失败"+"车牌号码不能为空"+bean.toString());
            return new Response<String>("900005", "车牌号码不能为空");
        }
        ParkInfoExample parkInfoExample=new ParkInfoExample();
        ParkInfoExample.Criteria criteria=parkInfoExample.createCriteria();
        criteria.andCodeEqualTo(bean.getCode());
        criteria.andCompanycodeEqualTo(bean.getCompanyCode());
        List<ParkInfo> parkInfoList=parkInfoService.selectByExample(parkInfoExample);
        if(parkInfoList==null||parkInfoList.size()==0){
            log.info("平台向停车场推送停车记录中的车是否自动付费"+ResponseData.MSG_100001+bean.toString());
            return new Response<String>(ResponseData.CODE_100001, ResponseData.MSG_100001);
        }
        //查询用户信息
        Account account=accountService.selectByPrimaryKey(bean.getRecordId());
        if(account==null||account.getRecordid()==null){
            log.info("平台向停车场推送停车记录中的车是否自动付费"+ResponseData.MSG_100002+bean.toString());
            return new Response<String>(ResponseData.CODE_100002, ResponseData.MSG_100002);
        }
        DBConnection dbConnection=new DBConnection(parkInfoList.get(0).getDburl(),parkInfoList.get(0).getDbuserid(),parkInfoList.get(0).getDbpassword());
        String sql="",free_type="",is_free="",whtc_arrears_money="",type="";
        // 0 可自动扣费 1-有欠费  2-不可扣费
        if(account.getStatus().compareTo(new BigDecimal("0"))==0){
            free_type="1";
        }else if(account.getStatus().compareTo(new BigDecimal("1"))==0){
            free_type="0";
        }else if(account.getStatus().compareTo(new BigDecimal("2"))==0){
            free_type="0";
        }

        //判断是什么用户 0-非平台用户 1-武汉停车 2-内部车 3-会员车 4-协议车 5-联盟车辆
        if(account.getType().compareTo(new BigDecimal("0"))==0){
            //车辆是否欠费 0-否 1-是
            if(account.getIscararrear().compareTo(new BigDecimal("0"))==0){
                whtc_arrears_money="0";
            }else if(account.getIsacctarrear().compareTo(new BigDecimal("1"))==0){
                whtc_arrears_money=account.getCararrearamount().toString();
            }
            type="1";
            sql="update sys_parking set " +
                    "type = \'"+type+"\', " +
                    "is_free = \'"+is_free+"\', " +
                    "update_time = now() " +
                    "where id = \'"+account.getRecordid()+"\'";
        }else if(account.getType().compareTo(new BigDecimal("1"))==0){
            //账号是否欠费 0-否 1-是
            if(account.getIsacctarrear().compareTo(new BigDecimal("0"))==0){
                whtc_arrears_money="0";
            }else if(account.getIsacctarrear().compareTo(new BigDecimal("1"))==0){
                whtc_arrears_money=account.getAcctarrearamount().toString();
            }
            type="2";
            free_type="2";
            sql="update sys_parking set " +
                    "type = \'"+type+"\', " +
                    "free_type = \'"+free_type+"\', " +
                    "is_free = \'"+is_free+"\', " +
                    "update_time = now() " +
                    "where id = \'"+account.getRecordid()+"\'";
        }else if(account.getType().compareTo(new BigDecimal("2"))==0){
            //账号是否欠费 0-否 1-是
            if(account.getIsacctarrear().compareTo(new BigDecimal("0"))==0){
                whtc_arrears_money="0";
            }else if(account.getIsacctarrear().compareTo(new BigDecimal("1"))==0){
                whtc_arrears_money=account.getAcctarrearamount().toString();
            }
            type="3";
            free_type="3";
            sql="update sys_parking set " +
                    "type = \'"+type+"\', " +
                    "free_type = \'"+free_type+"\', " +
                    "is_free = \'"+is_free+"\', " +
                    "update_time = now() " +
                    "where id = \'"+account.getRecordid()+"\'";
        }else if(account.getType().compareTo(new BigDecimal("3"))==0){
            //账号是否欠费 0-否 1-是
            if(account.getIsacctarrear().compareTo(new BigDecimal("0"))==0){
                whtc_arrears_money="0";
            }else if(account.getIsacctarrear().compareTo(new BigDecimal("1"))==0){
                whtc_arrears_money=account.getAcctarrearamount().toString();
            }
            type="2";
            free_type="1";
            sql="update sys_parking set " +
                    "type = \'"+type+"\', " +
                    "free_type = \'"+free_type+"\', " +
                    "is_free = \'"+is_free+"\', " +
                    "update_time = now()" +
                    "where id = \'"+account.getRecordid()+"\'";
        }else if(account.getType().compareTo(new BigDecimal("4"))==0){
            //账号是否欠费 0-否 1-是
            if(account.getIsacctarrear().compareTo(new BigDecimal("0"))==0){
                whtc_arrears_money="0";
            }else if(account.getIsacctarrear().compareTo(new BigDecimal("1"))==0){
                whtc_arrears_money=account.getAcctarrearamount().toString();
            }
            free_type="4";
            sql="update sys_parking set " +
                    "free_type = \'"+free_type+"\', " +
                    "is_free = \'"+is_free+"\', " +
                    "update_time = now() " +
                    "where id = \'"+account.getRecordid()+"\'";
        }else if(account.getType().compareTo(new BigDecimal("5"))==0){
            //账号是否欠费 0-否 1-是
            if(account.getIsacctarrear().compareTo(new BigDecimal("0"))==0){
                whtc_arrears_money="0";
            }else if(account.getIsacctarrear().compareTo(new BigDecimal("1"))==0){
                whtc_arrears_money=account.getAcctarrearamount().toString();
            }
            free_type="5";
            sql="update sys_parking set " +
                    "free_type = \'"+free_type+"\', " +
                    "is_free = \'"+is_free+"\', " +
                    "update_time = now() " +
                    "where id = \'"+account.getRecordid()+"\'";
        }

        int i=dbConnection.insertOrUpdateOrDel(sql);
        dbConnection.releaseDB();
        if(i==0){
            log.info("平台向停车场推送停车记录中的车是否自动付费"+ResponseData.CODE_000001+bean.toString());
            return new Response<String>(ResponseData.CODE_000001, ResponseData.CODE_000001);
        }
        log.info("平台向停车场推送停车记录中的车是否自动付费"+ResponseData.CODE_000000+bean.toString());
        return new Response<String>(ResponseData.CODE_000000, ResponseData.CODE_000000);
    }

    @ApiOperation(value="平台向指定停车场查询该车辆是否还在停车场",notes = "平台向指定停车场查询该车辆是否还在停车场")
    @RequestMapping(value ="/PostIsCarinParkingInfo",method = RequestMethod.POST,
        consumes = "application/json; charset=UTF-8",
            produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Response<Parking> PostIsCarinParkingInfo(@RequestBody IsCarParkingInfo bean) throws ParseException {
        if (StringUtil.isNotNullStr(bean.getRecordId())) {
            log.info("平台向指定停车场查询该车辆是否还在停车场"+"请求失败"+"停车记录流水号不能为空");
            return new Response<Parking>("2", "停车场停车记录流水号不能为空");
        }

        if (StringUtil.isNotNullStr(bean.getCode())) {
            log.info("平台向指定停车场查询该车辆是否还在停车场"+"请求失败"+"停车场编号不能为空");
            return new Response<Parking>("2", "停车场编号不能为空");
        }

        if (StringUtil.isNotNullStr(bean.getCompanyCode())) {
            log.info("平台向指定停车场查询该车辆是否还在停车场"+"请求失败"+"运营编号不能为空");
            return new Response<Parking>("2", "运营编号不能为空参数");
        }

        if (StringUtil.isNotNullStr(bean.getPlate())) {
            log.info("平台向指定停车场查询该车辆是否还在停车场"+"请求失败"+"车牌号不能为空参数");
            return new Response<Parking>("2", "车牌号不能为空");
        }
        //连接停车场数据库
        ParkInfoExample parkInfoExample = new ParkInfoExample();
        ParkInfoExample.Criteria criteria1 = parkInfoExample.createCriteria();
        criteria1.andCodeEqualTo(bean.getCode());
        criteria1.andCompanycodeEqualTo(bean.getCompanyCode());
        List<ParkInfo> parkInfoList = parkInfoService.selectByExample(parkInfoExample);
        if(parkInfoList == null || parkInfoList.size() == 0){
            log.info("平台向指定停车场查询该车辆是否还在停车场，但是未找到该停车场信息");
            return new Response<Parking>("2", "未找到该停车场信息");
        }
        String url = parkInfoList.get(0).getDburl();
        String name = parkInfoList.get(0).getDbuserid();
        String pass = parkInfoList.get(0).getDbpassword();
        DBConnection dbConnection = new DBConnection(url,name,pass);
        String sql ="select * from sys_parking where id=\'"+bean.getRecordId()+"\' AND plate =\'"+bean.getPlate()+"\' AND plate_color=\'"+bean.getPlateColor()+"\';";
        System.out.println(sql);
        List  parkingList= dbConnection.select(sql);
        if(parkingList.size()==0)
        {
            log.info("停车场未找到该条记录 id="+bean.getRecordId()+"车牌="+bean.getPlate());
            return new Response<Parking>("3", "停车场未找到该条记录");
        }
        String ff=((HashMap)parkingList.get(0)).get("out_time")+"";
        if(((HashMap)parkingList.get(0)).get("out_time")+""==null || "null".equals(((HashMap)parkingList.get(0)).get("out_time")+""))
        {
            log.info("该车未离场 id="+bean.getRecordId()+"车牌="+bean.getPlate());
            return new Response<Parking>("1", "该车在场内");
        }else{
            log.info("该车已离场 id="+bean.getRecordId()+"车牌="+bean.getPlate());
            String dateOut_time=((HashMap)parkingList.get(0)).get("out_time").toString();
            dateOut_time = dateOut_time.substring(0,dateOut_time.length() - 2);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟
            String dstr=dateOut_time;
            java.util.Date date=sdf.parse(dstr);

            //实收,应收转换为分
            String  real_income =((HashMap)parkingList.get(0)).get("real_income").toString();
            //real_income=real_income.substring(0,real_income.length()-3);
            String  must_income =((HashMap)parkingList.get(0)).get("must_income").toString();
            int real_incomeInt=Integer.parseInt(real_income.substring(0,real_income.length()-3));
            int must_incomeInt=Integer.parseInt(must_income.substring(0,real_income.length()-3));
            Parking parking =new Parking();
            parking.setId(bean.getRecordId());
            parking.setPlate(bean.getPlate());
            parking.setOuttime(date);
            parking.setRealpaycash(new BigDecimal( real_incomeInt*100));
            parking.setMustpaycash(new BigDecimal(must_incomeInt*100));
            //修改平台数据库信息（同时，如果该接口提供给联盟，那么也是在此处调用）
           int updateS= parkingService.updateSelective(parking);
            if (updateS==0)
            {
                    log.info("该车已离场id="+bean.getRecordId()+"车牌="+bean.getPlate()+"但是修改平台数据失败");
            }else{
                log.info("该车已离场id="+bean.getRecordId()+"车牌="+bean.getPlate()+"修改平台数据成功");
            }
            return new Response<Parking>("0", "该车已离场",parking);
        }
    }

    @ApiOperation(value="平台向停车场推送扣费结果",notes="平台向停车场推送扣费结果")
    @RequestMapping(value="/payment_result",method= RequestMethod.POST)
    @ResponseBody
    public Response<ParkingFeeVo> getPaymentResult(@ModelAttribute ParkingFeeDto bean) {

        ParkingExample parkingExample = new ParkingExample();
        ParkingExample.Criteria criteria = parkingExample.createCriteria();
        Parking parking=new Parking();
        if (bean.getRecordId() != null) {
            criteria.andIdEqualTo(bean.getRecordId());
            parking.setId(bean.getRecordId());
            Short paytype=4;
            parking.setPaytype(paytype);
            parkingService.updateSelective(parking);
        }
        List<Parking> parkings = parkingService.selectByExample(parkingExample);
        if (parkings != null && parkings.size() > 0) {
            ParkingFeeVo parkingFeeVo = new ParkingFeeVo();
            if (parkings.get(0).getPaystatus() != null && !("").equals(parkings.get(0).getPaystatus())) {
                parkingFeeVo.setStatus(parkings.get(0).getPaystatus().intValue());
            }
            if (parkings.get(0).getRealpaycash() != null && !("").equals(parkings.get(0).getRealpaycash())) {
                parkingFeeVo.setPayFee(parkings.get(0).getRealpaycash().intValue());
            } else {
                parkingFeeVo.setPayFee(0);
            }

            BigDecimal realpaycash = new BigDecimal("0");
            if (parkings.get(0).getRealpaycash() != null && !("").equals(parkings.get(0).getRealpaycash())) {
                realpaycash = parkings.get(0).getRealpaycash();
            }
            //连接停车场数据库
            ParkInfoExample parkInfoExample = new ParkInfoExample();
            ParkInfoExample.Criteria criteria1 = parkInfoExample.createCriteria();
            criteria1.andCodeEqualTo(bean.getCode());
            criteria1.andCompanycodeEqualTo(bean.getCompanyCode());
            List<ParkInfo> parkInfoList = parkInfoService.selectByExample(parkInfoExample);
            if(parkInfoList == null || parkInfoList.size() == 0){
                return new Response<ParkingFeeVo>(ResponseData.CODE_000001, ResponseData.MSG_000001, null);
            }

            String url = parkInfoList.get(0).getDburl();
            String name = parkInfoList.get(0).getDbuserid();
            String pass = parkInfoList.get(0).getDbpassword();
            DBConnection dbConnection = new DBConnection(url,name,pass);
            String sql ="";
            if(bean.getRealincome() != null && !"".equals(bean.getRealincome())){
                //将金额单位转换为元
                bean.setRealincome((Integer.parseInt(bean.getRealincome())/100)+"");
            }else{
                bean.setRealincome(0+"");
            }
            if(bean.getAcctArrearAmount() !=null && !"".equals(bean.getAcctArrearAmount()))
            {
                //将欠费金额单位转换为元(根本没卵用的需求，非要加欠费金额！！！)
                bean.setAcctArrearAmount(bean.getAcctArrearAmount()/100);
            }else{
                bean.setAcctArrearAmount(0);
            }
//                if(bean.getStatus() !=0 && "0".equals(bean.getStatus())){
//                    sql = "update sys_parking " +
//                            "set  update_time = now(),"+
//                            "real_income="+bean.getRealincome()+
//                            ",pay_type='4',plate_mode= '1' "+
//                            "where id=\'" + bean.getRecordId() + "\';";
//                }else{
            //武汉停车用户支付
            if(bean.getPaymentId() !=null && ! "".equals(bean.getPaymentId())) {
                sql = "update sys_parking " +
                        "set  update_time = now(),free_type='2'"+
                        ",real_income="+bean.getRealincome()+",pay_type='4',plate_mode= '0' "+
                         "where id=\'" + bean.getRecordId() + "\';";
            }else{
                sql = "update sys_parking " +
                        "set update_time = now(),out_time=\'"+bean.getOutTime()+"\'"+
                        ",real_income="+bean.getRealincome()+",is_free='1',pay_type='4',plate_mode= '0' "+
                        "where id=\'" + bean.getRecordId() +"\';";
            }
//                }
            System.out.println(sql);
            int i = dbConnection.insertOrUpdateOrDel(sql);
            dbConnection.releaseDB();

            if (i == 0) {
                log.info("平台向停车场推送扣费结果"+ResponseData.MSG_000001+bean.toString());
                return new Response<ParkingFeeVo>(ResponseData.CODE_000001, ResponseData.MSG_000001, null);
            } else {
                log.info("平台向停车场推送扣费结果"+ResponseData.MSG_000000+bean.toString());
                //-----------------暂定出车，让APP显示正确--------------------
                SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
                ParkingNoticeOutDto parkingNoticeOutDto=new ParkingNoticeOutDto();
                parkingNoticeOutDto.setRecordId(bean.getRecordId());
                parkingNoticeOutDto.setCode(bean.getCode());
                parkingNoticeOutDto.setCompanyCode(bean.getCompanyCode());
                parkingNoticeOutDto.setPlate(bean.getPlate());
                parkingNoticeOutDto.setPlateColor(bean.getPlateColor());
                parkingNoticeOutDto.setInTime(sdf.format(parkings.get(0).getIntime()));
                parkingNoticeOutDto.setOutTime(bean.getOutTime());
                parkingNoticeOutDto.setPayFee(0);
                parkingNoticeOutDto.setPaymentTime(CommonUtils.formatDateToString(new Date(),CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
                parkingNoticeOutDto.setPaymentAppId(bean.getRecordId());
                    //自动扣费不用再推，手动缴费推
                if(bean.getPaymentId() ==null ||  "".equals(bean.getPaymentId())) {
                    JSONObject jsonObject = JSONObject.fromObject(
                            HttpRequest.sendPost(Constants.LM_INF_URL1 + "/upstream_inf/parking_notice_out", EntityToMap.ConvertObjToMap(parkingNoticeOutDto)));
                    if ("000000".equals(jsonObject.get("code"))) {
                        log.info("停车场向平台推送用来完结APP的交易记录" + ResponseData.MSG_000000);
                        return new Response<ParkingFeeVo>(ResponseData.CODE_000000, ResponseData.MSG_000000, parkingFeeVo);
                    }else{
                        log.info("停车场向平台推送用来完结APP的交易记录" + ResponseData.MSG_000001);
                        return new Response<ParkingFeeVo>(ResponseData.CODE_000001, ResponseData.MSG_000001, parkingFeeVo);
                    }
                }
                return new Response<ParkingFeeVo>(ResponseData.CODE_000000, ResponseData.MSG_000000, parkingFeeVo);
            }

        } else {
            log.info("平台向停车场推送扣费结果"+ResponseData.MSG_000005+bean.toString());
            return new Response<ParkingFeeVo>(ResponseData.CODE_000005, ResponseData.MSG_000005, null);
        }
    }

    @ApiOperation(value="已知一个值，查出相关的数据信息",notes="平台向停车场推送扣费结果")
    @RequestMapping(value="/payment_texttexttexttext",method= RequestMethod.POST)
    @ResponseBody
    public Response<ParkingFeeVo> gettexttexttext(@RequestBody String  plate) {

            //连接停车场数据库
            ParkInfoExample parkInfoExample = new ParkInfoExample();
            ParkInfoExample.Criteria criteria1 = parkInfoExample.createCriteria();
            criteria1.andCodeEqualTo("17");
            criteria1.andCompanycodeEqualTo("90003");
            List<ParkInfo> parkInfoList = parkInfoService.selectByExample(parkInfoExample);
            if(parkInfoList == null || parkInfoList.size() == 0){
                return new Response<ParkingFeeVo>(ResponseData.CODE_000001, ResponseData.MSG_000001, null);
            }

            String url = parkInfoList.get(0).getDburl();
            String name = parkInfoList.get(0).getDbuserid();
            String pass = parkInfoList.get(0).getDbpassword();
            DBConnection dbConnection = new DBConnection(url,name,pass);
            String sql ="SELECT * FROM information_schema.COLUMNS WHERE table_schema = 'park';";
            List list= dbConnection.select(sql);
            dbConnection.releaseDB();
            for (int i=0;i<list.size();i++)
            {
                JSONObject jSONObject=null;
                jSONObject=JSONObject.fromObject(list.get(i));
                String tables=  jSONObject.get("TABLE_NAME").toString();
                String column=  jSONObject.get("COLUMN_NAME").toString();
                String sqlhaizi="select * from "+tables+" where "+column+" = '"+plate+"';" ;
                System.out.println("========");
                System.out.println(sqlhaizi);
                System.out.println("========");
                DBConnection dbConnections = new DBConnection(url,name,pass);
                List listhaizi= dbConnections.select(sqlhaizi);
                dbConnections.releaseDB();
                if(listhaizi.size()>0)
                {
                    System.out.print("");
                    System.out.print("");
                    System.out.println("");
                    System.out.println("");

                    for(int y=0; y<listhaizi.size();y++)
                    {
                        System.out.println(listhaizi.get(y));
                    }
                }
            }

     return  new Response<ParkingFeeVo>(ResponseData.CODE_000005, ResponseData.MSG_000005, null);
    }

    @ApiOperation(value="平台向停车场推送停车用户信息",notes = "平台向停车场推送停车用户信息")
    @RequestMapping(value ="/send_parking_userinfo",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> postpartinguserinfo(@ModelAttribute UserInfosDto bean) throws Exception {
        System.out.println("+++++++++++++============="+bean.getAcctArrearAmount()+"+++++++++++================");
        //        停车记录标识
        if (StringUtil.isNotNullStr(bean.getRecordId())) {
            log.info("平台向停车场推送停车用户信息"+"请求失败"+"停车记录流水号不能为空"+bean.getRecordId());
            return new Response<String>("000001", "停车场停车记录流水号不能为空");
        }
        if (StringUtil.isNotNullStr(bean.getCode())) {
            log.info("平台向停车场推送停车用户信息"+"请求失败"+"停车场编号不能为空"+bean.getCode());
            return new Response<String>("000002", "停车场编号不能为空");
        }
        if (StringUtil.isNotNullStr(bean.getCompanyCode())) {
            log.info("平台向停车场推送停车用户信息"+"请求失败"+"运营平台编号不能为空"+bean.getCompanyCode());
            return new Response<String>("000003", "运营平台编号不能为空");
        }
        //连接停车场数据库
        ParkInfoExample parkInfoExample = new ParkInfoExample();
        ParkInfoExample.Criteria criteria1 = parkInfoExample.createCriteria();
        criteria1.andCodeEqualTo(bean.getCode());
        criteria1.andCompanycodeEqualTo(bean.getCompanyCode());
        List<ParkInfo> parkInfoList = parkInfoService.selectByExample(parkInfoExample);
        if(parkInfoList == null || parkInfoList.size() == 0){
            log.info("平台向停车场推送停车用户信息"+"请求失败"+"未找到该停车场信息"+bean.getCompanyCode());
            return new Response<String>("000004", "未找到该停车场信息", bean.getCode());
        }
        String url = parkInfoList.get(0).getDburl();
        String name = parkInfoList.get(0).getDbuserid();
        String pass = parkInfoList.get(0).getDbpassword();
        DBConnection dbConnection = new DBConnection(url,name,pass);
        //新增工行支付方式 ，返回工行标识
        if(bean.getFreetype()!="2" && !"2".equals(bean.getFreetype())){
            ParkingExample parkingExample = new ParkingExample();
            ParkingExample.Criteria criteria = parkingExample.createCriteria();
            criteria.andIdEqualTo(bean.getRecordId());
            List<Parking> list= parkingService.selectByExample(parkingExample);
            BankICB bankICB = new BankICB();
            bankICB.setParkingNum(bean.getRecordId());
            bankICB.setPlateNumber(list.get(0).getPlate());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String intime = dateFormat.format(list.get(0).getIntime());
            bankICB.setStartTime(intime);
            bankICB.setUserStatus(0);
            //调用工行接口
            Map<String, String> params = new HashMap<String, String>();
            params.put("userStatus",bankICB.getUserStatus().toString());
            params.put("parkingNum",bankICB.getParkingNum().toString());
            params.put("startTime",bankICB.getStartTime().toString());
            params.put("plateNumber",bankICB.getPlateNumber().toString());
            params.put("parkCode",bean.getCode());
            JSONObject jsonObject1 =JSONObject.fromObject(EJTRequest.callEJT(Constants.LM_INF_URL4+"/etcp/api/v1/external/depot/entersyn",params));
            //String s=jsonObject1.get("messagecode").toString();
            log.info("工行返回结果："+jsonObject1);
            log.info("返回码："+jsonObject1.get("messagecode"));
            log.info("车牌号："+bankICB.getPlateNumber().toString());
            if(! "10000".equals(jsonObject1.get("messagecode").toString())){
                log.info("停车场向平台推送停车场记录"+ResponseData.MSG_000001+bean.toString());
                return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001);
            }else {
                String sql = "update sys_parking " +
                        "set free_type='6'where id=\'" + bean.getRecordId() +"\';";
                int i = dbConnection.insertOrUpdateOrDel(sql);
                dbConnection.releaseDB();
                if(i>0) {
                    log.info("停车场向平台推送停车场记录" + ResponseData.MSG_000000 + bean.toString());
                    return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001);
                }else {
                    log.info("停车场向平台推送停车场记录" + ResponseData.MSG_000001 + bean.toString());
                    return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001);
                }
            }
        }




        if(bean.getUsermoney()==null || "".equals(bean.getUsermoney()))
        {
            bean.setUsermoney(new BigDecimal(0));
        }
        if(bean.getExtfield1()==null || "".equals(bean.getExtfield1()))
        {
            bean.setExtfield1("2");
        }
        AccountExample accountExample=new AccountExample();
        AccountExample.Criteria criteria=accountExample.createCriteria();
        criteria.andCodeEqualTo(bean.getCode());
        criteria.andCompanycodeEqualTo(bean.getCompanyCode());
        criteria.andRecordidEqualTo(bean.getRecordId());
        List<Account> accountList=accountService.selectByExample(accountExample);
        if(accountList.get(0).getCararrearamount() ==null || "0".equals(accountList.get(0).getCararrearamount()))
        {
            bean.setAcctArrearAmount(0);
        }else{
            //将欠费金额单位转换为元
            int acctArrearAmount=accountList.get(0).getCararrearamount().intValue();
            bean.setAcctArrearAmount(acctArrearAmount/100);
        }
        String sql = "update sys_parking " +
                "set free_type='2' ,whtc_arrears_update_time=now() ,whtc_arrears_money="+bean.getAcctArrearAmount()+",user_money=\'"+bean.getUsermoney()+"\',ext_field1=\'"+bean.getExtfield1()+"\'"+
                "where id=\'" + bean.getRecordId() +"\';";
        System.out.println("+++++++++++++============="+bean.getAcctArrearAmount()+"+++++++++++================后面处理化分");
        System.out.println(sql);
        int i = dbConnection.insertOrUpdateOrDel(sql);
        dbConnection.releaseDB();
        if (i == 0) {
            log.info("平台向停车场推送停车用户信息"+"请求成功，但修改失败"+bean.getRecordId());
            return new Response<String>("000006", "请求成功，但修改失败");
        } else {
            log.info("平台向停车场推送停车用户信息"+ResponseData.MSG_000000+bean.toString());
            return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000);
        }
    }

    @ApiOperation(value="停车场向联盟发送及时泊位数信息",notes = "停车场向联盟发送及时泊位数信息")
    @RequestMapping(value ="/send_parkinginfo_availableberthcount",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> sendavailableberthcount(@ModelAttribute ParkinfosDto bean){
    ParkInfo parkInfo = parkInfoService.selectByPrimaryKey(bean.getCode());
    if (parkInfo == null) {
        log.info("停车场向联盟发送及时泊位数信息"+ResponseData.MSG_000005+bean.toString());
        return new Response<String>(ResponseData.CODE_000005, ResponseData.MSG_000005, "停车场编号不存在！");
    }
    if(bean.getCode() ==null || "".equals(bean.getCode()) || bean.getCompanyCode()==null ||"".equals(bean.getCompanyCode())){
        log.info("停车场向联盟发送及时泊位数信息"+ResponseData.MSG_100001+bean.toString());
        return new Response<String>(ResponseData.CODE_100001, ResponseData.MSG_100001, "停车场编号或运营公司编号不能为空！");
    }
    ParkInfo parkInfo1=new ParkInfo();
    parkInfo1.setCode(bean.getCode());
    parkInfo1.setCompanycode(bean.getCompanyCode());
    parkInfo1.setTotalnum( new BigDecimal(bean.getTotalNum()));
    parkInfo1.setEmptynum(new BigDecimal(bean.getEmptyNum()));
    int updateParkCount=parkInfoService.updateSelective(parkInfo1);
    JSONObject jsonObject = JSONObject.fromObject(HttpRequest.sendPost2(Constants.LM_INF_URL2 + "/PostPklotBerthInfo", EntityToMap.ConvertObjToMap(bean)));
    if ("0".equals(jsonObject.get("code"))) {
        log.info("停车场向联盟发送及时泊位数信息"+ResponseData.MSG_000000+bean.toString());
        return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000);
    }
        log.info("停车场向联盟发送及时泊位数信息"+ResponseData.MSG_000001+bean.toString());
    return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001, "请求失败");

}

}
