package com.jemmyee.inf.controller.downstream;

import com.jemmyee.core.connect.DBConnection;
import com.jemmyee.core.utils.CommonUtils;
import com.jemmyee.core.web.Response;
import com.jemmyee.core.web.ResponseData;
import com.jemmyee.inf.dto.Paymoney;
import com.jemmyee.inf.dto.PaymoneyDto;
import com.jemmyee.inf.entity.ParkInfo;
import com.jemmyee.inf.entity.ParkInfoExample;
import com.jemmyee.inf.entity.Parking;
import com.jemmyee.inf.entity.ParkingExample;
import com.jemmyee.inf.service.IParkInfoService;
import com.jemmyee.inf.service.IParkingService;
import com.jemmyee.inf.service.ParkingServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */
@Api(value="downParking", description="下行--停车记录")
@Controller("DownParkingController")
@RequestMapping("/downstream_inf")
public class DownParkingController {

    Log log = LogFactory.getLog( this .getClass());
    @Autowired
    private IParkInfoService parkInfoService;

    @Autowired
    private IParkingService parkingService;

    @ApiOperation(value="移动端向停车场查询指定车辆金额（单位分）",notes="移动端向停车场查询指定车辆金额（单位分）")
    @RequestMapping(value="/paymoney",method= RequestMethod.POST)
    @ResponseBody
    public Response<String> paymoney(@ModelAttribute Paymoney bean) throws ParseException {
        if(bean.getCode() ==null || "".equals(bean.getCode())){
            log.info("移动端向停车场查询指定车辆金额（单位分）"+"停车场编号不能为空！"+bean.getCode());
            return new Response<String>(ResponseData.CODE_100001, ResponseData.MSG_100001);
        }
        if(bean.getPlate() ==null || "".equals(bean.getPlate()))
        {
            log.info("移动端向停车场查询指定车辆金额（单位分）"+"车牌号不能为空！"+bean.getPlate());
            return new Response<String>(ResponseData.CODE_400001, ResponseData.MSG_400001);
        }
        ParkInfoExample parkInfoExample=new ParkInfoExample();
        ParkInfoExample.Criteria criteria=parkInfoExample.createCriteria();
        criteria.andCodeEqualTo(bean.getCode());
        List<ParkInfo> parkInfoList=parkInfoService.selectByExample(parkInfoExample);
        if(parkInfoList==null||parkInfoList.size()==0){
            log.info("移动端向停车场查询指定车辆金额（单位分"+"停车场编号错误！");
            return new Response<String>(ResponseData.CODE_100001, ResponseData.MSG_100001);
        }
        DBConnection dbConnection=new DBConnection(parkInfoList.get(0).getDburl(),parkInfoList.get(0).getDbuserid(),parkInfoList.get(0).getDbpassword());
        String sql ="select * from sys_parking where plate='"+bean.getPlate()+"' and out_time is null and delete_flag='0';";
        System.out.println(sql);
        List  parkingList= dbConnection.select(sql);
        if(parkingList.size()==0)
        {
            log.info("停车场未找到该条记录"+bean.getPlate());
            return new Response<String>(ResponseData.CODE_100002, "停车场未找到该条记录");
        }
        //查询该车是否是会员车
        String memberId=((HashMap)parkingList.get(0)).get("member_id")+"";
        String money="0";
        int menberisOverdue=0;//0未过期1已过期

        if(!"null".equals(memberId)){
            DBConnection dbConnectionmember=new DBConnection(parkInfoList.get(0).getDburl(),parkInfoList.get(0).getDbuserid(),parkInfoList.get(0).getDbpassword());
            String sqlmember ="select * from sys_member where id='"+memberId+"';";
            System.out.println(sql);
            List  memberList= dbConnection.select(sqlmember);
            String enddate=((HashMap)memberList.get(0)).get("end_time")+"";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date endTime=sdf.parse(enddate);
            //当前时间对比会员结束时间
            CommonUtils commonUtils=new CommonUtils();
                if(commonUtils.comparemin(new Date(), endTime)){//当前时间在会员结束时间之前
                    money="0";
                }else {
                    memberId="null";
                    menberisOverdue=1;
                }
        }
        if("null".equals(memberId) || menberisOverdue==1){
            ParkingExample parkingExample=new ParkingExample();
            ParkingExample.Criteria criteriaParking=parkingExample.createCriteria();
            criteriaParking.andPlateEqualTo(bean.getPlate());
            criteriaParking.andParkcodeEqualTo(bean.getCode());
            criteriaParking.andOuttimeIsNull();
            parkingExample.setOrderByClause("INTIME DESC");
            List<Parking> parkingLists=parkingService.selectByExample(parkingExample);
            if(parkingLists.size()==0 ||parkingLists==null){
                log.info("停车场平台未找到该条记录"+bean.getPlate());
                return new Response<String>(ResponseData.CODE_100002, "停车场平台未找到该条记录");
            }
            //判断当前时间对应在十个收费段哪一段，来决定收费多少
            Date datetime=new Date();
            Parking payparking=parkingLists.get(0);
            Date d0=payparking.getIntime();
            Date d1=payparking.getOuttime1();
            Date d2=payparking.getOuttime2();
            Date d3=payparking.getOuttime3();
            Date d4=payparking.getOuttime4();
            Date d5=payparking.getOuttime5();
            Date d6=payparking.getOuttime6();
            Date d7=payparking.getOuttime7();
            Date d8=payparking.getOuttime8();
            Date d9=payparking.getOuttime9();
            Date d10=payparking.getOuttime10();
            CommonUtils commonUtils=new CommonUtils();
            if(commonUtils.comparemin(datetime, d1)){
                money=payparking.getPayfee1().toString();
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
            }else if(commonUtils.comparemin(new Date(), d2)){
                money=payparking.getPayfee2().toString();
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
            }else if(commonUtils.comparemin(new Date(), d3)){
                money=payparking.getPayfee3().toString();
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
            }else if(commonUtils.comparemin(new Date(), d4)){
                money=payparking.getPayfee4().toString();
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
            }else if(commonUtils.comparemin(new Date(), d5) ){
                money=payparking.getPayfee5().toString();
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
            }else if(commonUtils.comparemin(new Date(), d6)){
                money=payparking.getPayfee6().toString();
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
            }else if(commonUtils.comparemin(new Date(), d7)){
                money=payparking.getPayfee7().toString();
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
            }else if(commonUtils.comparemin(new Date(), d8)){
                money=payparking.getPayfee8().toString();
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
            } else if(commonUtils.comparemin(new Date(), d9)){
                money=payparking.getPayfee9().toString();
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
            }else if(commonUtils.comparemin(new Date(), d10)){
                money=payparking.getPayfee10().toString();
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
            }else {
                money=payparking.getPayfee10().toString();
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
            }
        }
        return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000,money);
    }


    @ApiOperation(value="移动端支付成功后，修改停车场指定车辆停车信息",notes="移动端支付成功后，修改停车场指定车辆停车信息")
    @RequestMapping(value="/paymoney_success",method= RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> paymoneySuccess(@ModelAttribute PaymoneyDto bean) throws ParseException {
            if(bean.getPlate() ==null ||"".equals(bean.getPlate())){
                log.info("移动端支付成功后，修改停车场指定车辆停车信息"+"车牌号不能为空！"+bean.getCode());
                return new Response<Boolean>(ResponseData.CODE_400001, ResponseData.MSG_400001,false);
            }
            if(bean.getCode() ==null || "".equals(bean.getCode())){
                log.info("移动端支付成功后，修改停车场指定车辆停车信息"+"停车场编号不能为空！"+bean.getCode());
                return new Response<Boolean>(ResponseData.CODE_100001, ResponseData.MSG_100001,false);
            }
        ParkInfoExample parkInfoExample=new ParkInfoExample();
        ParkInfoExample.Criteria criteria=parkInfoExample.createCriteria();
        criteria.andCodeEqualTo(bean.getCode());
        List<ParkInfo> parkInfoList=parkInfoService.selectByExample(parkInfoExample);
        //拿到停车记录ID,确保只会修改停车场一条记录
        ParkingExample parkingExample=new ParkingExample();
        ParkingExample.Criteria criteria1=parkingExample.createCriteria();
        criteria1.andPlateEqualTo(bean.getPlate());
        criteria1.andParkcodeEqualTo(bean.getCode());
        criteria1.andOuttimeIsNull();
        parkingExample.setOrderByClause("INTIME DESC");
        List<Parking> parkings= parkingService.selectByExample(parkingExample);
        String id=parkings.get(0).getId();
        if(parkInfoList==null||parkInfoList.size()==0){
            log.info("移动端支付成功后，修改停车场指定车辆停车信息"+"停车场编号错误！");
            return new Response<Boolean>(ResponseData.CODE_100001, ResponseData.MSG_100001,false);
        }
        DBConnection dbConnection=new DBConnection(parkInfoList.get(0).getDburl(),parkInfoList.get(0).getDbuserid(),parkInfoList.get(0).getDbpassword());
        String sql ="select * from sys_parking where plate='"+bean.getPlate()+"' and out_time is null and delete_flag='0';";
        System.out.println(sql);
        List  parkingList= dbConnection.select(sql);
        if(parkingList.size()==0)
        {
            log.info("移动端支付成功后，修改停车场指定车辆停车信息++++停车场未找到该条记录"+bean.getPlate());
            return new Response<Boolean>(ResponseData.CODE_100002, "停车场未找到该条记录",false);
        }
        //释放连接池
        dbConnection.releaseDB();
        DBConnection dbConnectionUpdate=new DBConnection(parkInfoList.get(0).getDburl(),parkInfoList.get(0).getDbuserid(),parkInfoList.get(0).getDbpassword());
        String sqlupdate="UPDATE sys_parking SET out_time=now(),real_income='"+bean.getReal_income()+"' ,must_income='"+bean.getMust_income()+"',pay_type='1', sentry_box_pay='1',sentry_box_pay_time=now()  WHERE id='"+id+"'";
        log.info(sqlupdate);
              int  i=  dbConnectionUpdate.insertOrUpdateOrDel(sqlupdate);
        //释放连接池
        dbConnectionUpdate.releaseDB();
              if(i>0 && i==1){
                  log.info("移动端支付成功后，修改停车场指定车辆停车信息成功");
                  return new Response<Boolean>(ResponseData.CODE_000000, ResponseData.MSG_000000,true);
              }else if(i>1){
                  log.info("移动端支付成功后，修改停车场指定车辆停车信息时，修改了多条停车记录，请核查");
              }
        return new Response<Boolean>(ResponseData.CODE_100001, ResponseData.MSG_100001,false);
    }



}
