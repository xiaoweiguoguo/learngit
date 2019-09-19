package com.jemmyee.inf.controller.upstream;


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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/9/6.
 */
@Api(value="upTradeOrder", description="上行--交易订单")
@Controller("UpTradeOrderController")
@RequestMapping("/upstream_inf")
public class UpTradeOrderController {
    @Autowired
    private IParkingService parkingService;
    @Autowired
    private IAccountService accountService;

    @Autowired
    private IParkInfoService parkInfoService;

    Log log = LogFactory.getLog( this .getClass());
    @ApiOperation(value="停车场向平台推送交易记录",notes="停车场向平台推送交易记录")
    @RequestMapping(value="/send_payment_result",method= RequestMethod.POST)
    @ResponseBody
    public Response<SendPaymentDto> setPaymentResult(@ModelAttribute SendPaymentDto bean) {

        ParkingExample parkingExample = new ParkingExample();
        parkingExample.or().andIdEqualTo(bean.getRecordId());
        List<Parking> list = parkingService.selectByExample(parkingExample);
        if (list == null && list.size() ==0) {
            log.info("停车场向平台推送交易记录" + ResponseData.MSG_100002 + bean.toString());
            return new Response<SendPaymentDto>(ResponseData.CODE_100002, ResponseData.MSG_100002);
        }
        //修改bean字段不为null的值
        Parking parking = new Parking();
        parking.setId(bean.getRecordId());
        parking.setParkcode(bean.getCode());
        parking.setCompanycode(bean.getCompanyCode());
        parking.setPlate(bean.getPlate());
        if (bean.getPlateColor() != null && !("").equals(bean.getPlateColor())) {
            parking.setPlatecolor(bean.getPlateColor().shortValue());
        }
        if (bean.getVehicleType() != null && !("").equals(bean.getVehicleType())) {
            parking.setVehicletype(bean.getVehicleType().shortValue());
        }
        parking.setIntime(CommonUtils.parseStringToDateWithFormat(bean.getInTime(),"yyyyMMddHHmmss"));
        parking.setOuttime(CommonUtils.parseStringToDateWithFormat(bean.getOutTime(),"yyyyMMddHHmmss"));
        parking.setAppapplyorder(bean.getPaymentId());
        parking.setBerthcode(bean.getBerthCode());
        if (bean.getCategory() != null && !("").equals(bean.getCategory())) {
            parking.setParktype(bean.getCategory().shortValue());
        }
        if (bean.getPayFee() != null && !("").equals(bean.getPayFee())) {
            parking.setMustpaycash(new BigDecimal(bean.getPayFee()));
        }
        if (bean.getStatus() != null && !("").equals(bean.getStatus())) {
            parking.setPaystatus(bean.getStatus().shortValue());
        }
        parking.setUpdatetime(new Date());

        int i = parkingService.updateSelective(parking);
        if (i > 0) {
            //向联盟推送交易记录
            ParkingNoticeOutDto parkingNoticeOutDto = new ParkingNoticeOutDto();
            parkingNoticeOutDto.setPaymentAppId(bean.getPaymentId());
            parkingNoticeOutDto.setRecordId(bean.getRecordId());
            parkingNoticeOutDto.setCode(bean.getCode());
            parkingNoticeOutDto.setPlate(bean.getPlate());
            parkingNoticeOutDto.setPlateColor(bean.getPlateColor());
            parkingNoticeOutDto.setVehicleType(bean.getVehicleType());
            parkingNoticeOutDto.setCompanyCode(bean.getCompanyCode());
            parkingNoticeOutDto.setInTime(bean.getInTime());
            parkingNoticeOutDto.setOutTime(bean.getOutTime());
            parkingNoticeOutDto.setPayFee(bean.getPayFee());
            parkingNoticeOutDto.setPaymentTime(CommonUtils.formatDateToString(new Date(),CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));

            JSONObject jsonObject = JSONObject.fromObject(
                    HttpRequest.sendPost(Constants.LM_INF_URL1 + "/upstream_inf/parking_notice_out", EntityToMap.ConvertObjToMap(parkingNoticeOutDto)));
            if ("000000".equals(jsonObject.get("code"))) {
                log.info("停车场向平台推送交易记录" + ResponseData.MSG_000000 + bean.toString());
                return new Response<SendPaymentDto>(ResponseData.CODE_000000, ResponseData.MSG_000000, bean);
            }else{
                //连接停车场数据库
                ParkInfoExample parkInfoExample = new ParkInfoExample();
                ParkInfoExample.Criteria criteria1 = parkInfoExample.createCriteria();
                criteria1.andCodeEqualTo(bean.getCode());
                criteria1.andCompanycodeEqualTo(bean.getCompanyCode());
                List<ParkInfo> parkInfoList = parkInfoService.selectByExample(parkInfoExample);
                if(parkInfoList == null || parkInfoList.size() == 0){
                    log.info("扣费失败后，往停车场数据库修改字段为7.扣费失败，但是为找到该停车场信息");
                    return new Response<SendPaymentDto>(ResponseData.CODE_000001, ResponseData.MSG_000001, null);
                }
                String url = parkInfoList.get(0).getDburl();
                String name = parkInfoList.get(0).getDbuserid();
                String pass = parkInfoList.get(0).getDbpassword();
                DBConnection dbConnection = new DBConnection(url,name,pass);
                String sql ="update sys_parking set  update_time = now(),plate_mode='1' where id=" + bean.getRecordId() + ";";
                System.out.println(sql);
                int u = dbConnection.insertOrUpdateOrDel(sql);
                dbConnection.releaseDB();
                if(u==0)
                {
                    log.info("扣费失败后，往停车场数据库修改字段plate_mode为1.扣费失败，但是修改失败");
                }else{
                    log.info("扣费失败后，往停车场数据库修改字段plate_mode为1.扣费失败，修改成功");
                }
            log.info("停车场向平台推送交易记录" + ResponseData.MSG_000001 + bean.toString());
            return new Response<SendPaymentDto>(ResponseData.CODE_000001, ResponseData.MSG_000001);
            }
        } else {
            log.info("停车场向平台推送交易记录" + ResponseData.MSG_000001 + bean.toString());
            return new Response<SendPaymentDto>(ResponseData.CODE_000001, ResponseData.MSG_000001);
        }

    }
    @ApiOperation(value="自建停车场向平台查询用户信息",notes="自建停车场向平台查询用户信息")
    @RequestMapping(value="/parking_account",method= RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 000000, message = "请求成功"),
            @ApiResponse(code = 000001, message = "请求失败"),
            @ApiResponse(code = 000002, message = "未知错误"),
            @ApiResponse(code = 000003, message = "停车ID不能为空")
    })
    @ResponseBody
    public Response<Account> parking_account(@ModelAttribute ParkingRecordDto ben) {
        //        停车记录标识
        if (StringUtil.isNotNullStr(ben.getRecordId())) {
            log.info("自建停车场向平台查询用户信息"+"请求失败"+"停车记录流水号不能为空"+ben.getRecordId());
            return new Response<Account>("700001", "停车场停车记录流水号不能为空");
        }
        Account account=new Account();
        account.setRecordid(ben.getRecordId());
        AccountExample accountExample=new AccountExample();
        AccountExample.Criteria criteria1= accountExample.createCriteria() ;
        criteria1.andRecordidEqualTo(account.getRecordid());
        List<Account> accountslist=accountService.selectByExample(accountExample);
        if(accountslist.size() !=0){
            log.info("自建停车场向平台查询用户信息"+"请求成功"+accountslist.get(0).toString());
            return new Response<Account>("000000", "请求成功",accountslist.get(0));
        }else{
            log.info("自建停车场向平台查询用户信息"+"请求成功但是未查询到指定结果");
            return new Response<Account>("000001", "请求成功但是未查询到指定结果",null);
        }
    }
    @ApiOperation(value="自建停车场向联盟平台提交车辆出场信息(现金支付)",notes="自建停车场向联盟平台提交车辆出场信息(现金支付)")
    @RequestMapping(value="/parking_record_out_inform",method= RequestMethod.POST)
    @ApiResponses(value = {
            //@ApiResponse(code = 700001, message = "停车场停车记录流水号不能为空"),
            @ApiResponse(code = 700002, message = "停车场编号不能为空"),
            @ApiResponse(code = 700003, message = "停车平台编号不能为空"),
            @ApiResponse(code = 700004, message = "车牌号不能为空"),
            @ApiResponse(code = 700005, message = "车牌颜色不能为空"),
            @ApiResponse(code = 700006, message = "时间格式为yyyyMMddHHmmss"),
            @ApiResponse(code = 700007, message = "应付费用不能为空"),
            @ApiResponse(code = 000000, message = "请求成功"),
            @ApiResponse(code = 000001, message = "请求失败"),
            //@ApiResponse(code = 000001, message = "未知错误"),
    })
    @ResponseBody
    public Response<String> hasNewParking(@ModelAttribute ParkingRecordOutDto bean) {
//        停车记录标识
        if (StringUtil.isNotNullStr(bean.getRecordId())) {
            log.info("自建停车场向联盟平台提交车辆出场信息(现金支付)"+"请求失败"+"停车场停车记录流水号不能为空");
            return new Response<String>("700001", "停车场停车记录流水号不能为空");
        }
        //停车场编号
        if (StringUtil.isNotNullStr(bean.getCode())) {
            log.info("自建停车场向联盟平台提交车辆出场信息(现金支付)"+"请求失败"+"停车场编号不能为空");
            return new Response<String>("700002", "停车场编号不能为空");
        }
        //停车平台编号
        if (StringUtil.isNotNullStr(bean.getCompanyCode())) {
            log.info("自建停车场向联盟平台提交车辆出场信息(现金支付)"+"请求失败"+"停车平台编号不能为空");
            return new Response<String>("700003", "停车平台编号不能为空");
        }
        //车牌号
        if (StringUtil.isNotNullStr(bean.getPlate())) {
            log.info("自建停车场向联盟平台提交车辆出场信息(现金支付)"+"请求失败"+"车牌号不能为空");
            return new Response<String>("700004", "车牌号不能为空");
        }
        ParkingExample parkingExample = new ParkingExample();
        parkingExample.or().andIdEqualTo(bean.getRecordId());
        List<Parking> list = parkingService.selectByExample(parkingExample);
        if (list == null || list.size() == 0) {
            log.info("自建停车场向联盟平台提交车辆出场信息(现金支付)"+"请求失败"+"无记录"+bean);
            return new Response<String>(ResponseData.CODE_100002, ResponseData.MSG_100002);
        }else{
           // String outtime=list.get(0).getOuttime().toString();
            if(list.get(0).getOuttime() !=null &&  ! "".equals(list.get(0).getOuttime()))
            {
                log.info("自建停车场向联盟平台提交车辆出场信息(现金支付)"+"==========,平台已有出场");
                return new Response<String>(ResponseData.CODE_300003, ResponseData.MSG_300003);
            }
        }
        Parking parking = new Parking();
        parking.setId(bean.getRecordId());
        //停车场编号
        parking.setParkcode(bean.getCode());
        //停车平台编号
        parking.setCompanycode(bean.getCompanyCode());
        //车牌号
        parking.setPlate(bean.getPlate());
        //车牌颜色 0-蓝 1-黄 2-白 3-黑
        parking.setPlatecolor(Short.valueOf(bean.getPlateColor().toString()));
        //出场时间
        parking.setOuttime(CommonUtils.parseStringToDateWithFormat(bean.getOutTime(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //支付金额
        parking.setRealpaycash(new BigDecimal(bean.getPayCash()));
        //应付费用（分）
        if (bean.getPayFee()==null || bean.getPayFee()==0 || "0".equals(bean.getPayFee())) {
            parking.setMustpaycash(new BigDecimal(bean.getPayCash()));
        }else{
            parking.setMustpaycash(new BigDecimal(bean.getPayFee()));
        }
        //优惠券数量
        //优惠券ID
        if(bean.getTicketid() !=null && !"".equals(bean.getTicketid()))
            parking.setTicketid(new BigDecimal(bean.getTicketid()));
        if(bean.getTicketnum() !=null && !"".equals(bean.getTicketnum()))
            parking.setTicketnum(new BigDecimal(bean.getTicketnum()));

        if(bean.getPaytype()!=null)
        {
            parking.setPaytype(bean.getPaytype());//微信，支付宝，现金
        }
        int a = parkingService.updateSelective(parking);
        if(a<=0)
        {
            log.info("自建停车场向联盟平台提交车辆出场信息(现金支付)"+ResponseData.MSG_000001+"修改平台数据库失败"+parking.toString());
            return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001);
        }
        JSONObject jsonObject =JSONObject.fromObject(HttpRequest.sendPost(Constants.LM_INF_URL1 + "/upstream_inf/parking_record_out",
                EntityToMap.ConvertObjToMap(bean)));
        if (!"000000".equals(jsonObject.get("code"))) {
                log.info("自建停车场向联盟平台提交车辆出场信息(现金支付)"+ResponseData.MSG_000001+"数据到联盟失败,联盟无记录或已出车"+parking.toString());
                return new Response<String>(ResponseData.CODE_100011, ResponseData.MSG_100011);
        }
        log.info("自建停车场向联盟平台提交车辆出场信息(现金支付)"+ResponseData.MSG_000000+parking.toString());
        return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000);
    }

    @ApiOperation(value="停车场向平台推送银行代扣交易记录",notes="停车场向平台推送银行代扣交易记录")
    @RequestMapping(value="/send_payment_bank_withholding",method= RequestMethod.POST)
    @ResponseBody
    public Response<String> setPaymentBankWithholding(@ModelAttribute BankWithholding bean) throws Exception {
        log.info("停车记录id:"+bean.getParkingNum());
        log.info("车牌号"+bean.getPlateNumber());
        log.info("出场时间"+bean.getEndTime());
        log.info("停车费"+bean.getBilling());
        if(StringUtil.isNotNullStr(bean.getPlateNumber())) {
            log.info("停车场向平台推送银行代扣交易记录"+"请求失败"+"车牌号不能为空");
            return new Response<String>("000002", "车牌号不能为空");
        }
        if(StringUtil.isNotNullStr(bean.getParkingNum())){
            log.info("停车场向平台推送银行代扣交易记录"+"请求失败"+"停车场停车记录流水号不能为空");
            return new Response<String>("000002", "停车场停车记录流水号不能为空");
        }
        if(StringUtil.isNotNullStr(bean.getEndTime())){
            log.info("停车场向平台推送银行代扣交易记录"+"请求失败"+"出场时间不能为空");
            return new Response<String>("000002", "出场时间不能为空");
        }
        if(bean.getBilling() == null){
            log.info("停车场向平台推送银行代扣交易记录"+"请求失败"+"停车费用不能为空");
            return new Response<String>("000002", "停车费用不能为空");
        }
        ParkingExample parkingExample = new ParkingExample();
        ParkingExample.Criteria criteria = parkingExample.createCriteria();
        criteria.andIdEqualTo(bean.getParkingNum());
        List<Parking> list = parkingService.selectByExample(parkingExample);
        if (list == null || list.size() == 0) {
            log.info("停车场向平台推送银行代扣交易记录"+"请求失败"+"无记录"+bean);
            return new Response<String>(ResponseData.CODE_100002, ResponseData.MSG_100002);
        }else{
            if(list.get(0).getOuttime() !=null &&  ! "".equals(list.get(0).getOuttime()))
            {
                log.info("停车场向平台推送银行代扣交易记录"+"==========,平台已有出场");
                return new Response<String>(ResponseData.CODE_300003, ResponseData.MSG_300003);
            }
        }
        Parking parking = new Parking();
        parking.setId(bean.getParkingNum());
        //停车场编号
        parking.setParkcode(bean.getCode());
        //停车场编号
        parking.setCompanycode("90003");
        //车牌号
        parking.setPlate(bean.getPlateNumber());
        //车牌颜色 0-蓝 1-黄 2-白 3-黑
        parking.setPlatecolor(Short.valueOf(bean.getPlatecolor().toString()));
        //出场时间
        parking.setOuttime(CommonUtils.parseStringToDateWithFormat(bean.getEndTime(), CommonUtils.DATE_FORMAT_YYYYMMDDHHMMSS));
        //支付金额
        parking.setRealpaycash(bean.getBilling().multiply(new BigDecimal(100)));
        //应付费用（分）
        if (bean.getBilling()==null || "0".equals(bean.getBilling())) {
            parking.setMustpaycash(bean.getBilling().multiply(new BigDecimal(100)));
        }else{
            parking.setMustpaycash(bean.getBilling().multiply(new BigDecimal(100)));
        }

        int a = parkingService.updateSelective(parking);

        if(a<=0){
            log.info("停车场向平台推送银行代扣交易记录"+ResponseData.MSG_000001+"修改平台数据库失败"+parking.toString());
            return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001);
        }
        BankWith bankWith = new BankWith();
        bankWith.setParkingNum(bean.getParkingNum());
        bankWith.setPlateNumber(bean.getPlateNumber());
        bankWith.setBilling(bean.getBilling());
        bankWith.setDuration(bean.getDuration());
        bankWith.setEndTime(bean.getEndTime());
        //调用工行接口
        System.out.println( EntityToMap.ConvertObjToMap(bankWith));
        Map<String, String> params = new HashMap<String, String>();
        params.put("parkingNum",bankWith.getParkingNum().toString());
        params.put("plateNumber",bankWith.getPlateNumber().toString());
        try {

            SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = bean.getEndTime();
            Date date1 = dfm.parse(dateString);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String endtime = df.format(date1);
            params.put("endTime",endtime);
        }catch (Exception e){
            e.getLocalizedMessage();
        }
        params.put("duration",String.valueOf(bankWith.getDuration()));
        params.put("billing",bankWith.getBilling().toString());
        params.put("parkCode",bean.getCode());
        JSONObject jsonObject =JSONObject.fromObject(EJTRequest.callEJT(Constants.LM_INF_URL4+"/etcp/api/v1/external/depot/putoffsyn", params));
        log.info("工行出场返回结果："+jsonObject);
        log.info("返回码："+jsonObject.get("messagecode"));
        log.info("停车ID："+bankWith.getParkingNum().toString());
        String codeICB=jsonObject.get("messagecode").toString().toString();
        if ("20000".equals(codeICB)){
            Parking parking2=new Parking();
            //修改支付类型
            parking2.setPaytype((short)9);
            parking2.setId(bean.getParkingNum());
            int update= parkingService.updateSelective(parking2);
            if(update>0){
                //通知平台车辆已出场
                ParkingRecordOutDto parkingRecordOutDto = new ParkingRecordOutDto();
                Random random = new Random();
                String result="";
                for (int i=0;i<6;i++)
                {
                    result+=random.nextInt(10);
                }
                parkingRecordOutDto.setPaymentAppId(bean.getParkingNum().concat(result));
                parkingRecordOutDto.setRecordId(bean.getParkingNum());
                parkingRecordOutDto.setPlate(bean.getPlateNumber());
                parkingRecordOutDto.setPlateColor(bean.getPlatecolor());
                parkingRecordOutDto.setVehicleType(2);
                parkingRecordOutDto.setCompanyCode("90003");
                parkingRecordOutDto.setOutTime(bankWith.getEndTime());
                int f=bean.getBilling().multiply(new BigDecimal(100)).intValue();
                parkingRecordOutDto.setPayCash(new Integer(f));
                JSONObject jsonObject1 =JSONObject.fromObject(HttpRequest.sendPost(Constants.LM_INF_URL1 + "/upstream_inf/parking_record_out",
                        EntityToMap.ConvertObjToMap(parkingRecordOutDto)));
                if (!"000000".equals(jsonObject1.get("code"))) {
                    log.info("停车场向平台推送银行代扣交易记录"+ResponseData.MSG_000001+"数据到联盟失败,联盟无记录或已出车"+parking.toString());
                    return new Response<String>(ResponseData.CODE_100011, ResponseData.MSG_100011);
                }
                log.info("停车场向平台推送银行代扣交易记录"+ResponseData.MSG_000000+parking.toString());
                return new Response<String>(ResponseData.CODE_000000, ResponseData.MSG_000000);
            }else {
                log.info("停车场向平台推送银行代扣交易记录"+ResponseData.MSG_000001+bean.toString());
                return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001, null);
            }
        }else if("20002".equals(codeICB)){
            log.info("停车场向平台推送银行代扣交易记录失败，原因为银行方当前停车ID已经支付过");
            return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001);
        }else {
                log.info("停车场向平台推送银行代扣交易记录"+ResponseData.MSG_000000+parking.toString());
                return new Response<String>(ResponseData.CODE_000001, ResponseData.MSG_000001);

        }
    }
}

