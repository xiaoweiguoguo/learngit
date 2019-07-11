package com.xnjg.controller;

import com.xnjg.constant.Constants;
import com.xnjg.response.Response;
import com.xnjg.response.ResponseData;
import com.xnjg.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLEncoder;


/**
 * ==========================
 * Created with IntelliJ IDEA.
 *
 * @Auth: weixw
 * @Date: 2019/4/24 10:08
 * @Version 1.0.0
 * ==========================
 */
@Controller
@RequestMapping(value = "user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 通过车牌号获取用户的个人信息
     * @param plate 车牌号
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "userInfo",method = RequestMethod.GET)
    public ResponseData<String> getUserInfo(String plate) throws Exception{
        //车牌为空
        if(StringUtils.isEmpty(plate)){
            return new ResponseData(Response.CODE_001, Response.MSG_001);
        }
        String in2 = plate.substring(1);
        String in0 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><shareData><row><SFZMHM>"+ in2 + "</SFZMHM><resultfields>JDCXH|HPZL|HPHM|ZWPP|CLXH|YWPP|GCORJK|ZZG|ZZCMC|CLSBDH|FDJH|CLLX|CSYS|SYXZ|SFZMHM|SFZMMC|JDCSYR|SYQ|CCDJRQ|ZJDJRQ|JYYXQZ|QZBFQZ|FZJG|GLBM|DABH|GLXQ|JDCZT|DYBJ|CLLY|ZZLSH|FDJXH|RYZL|PL|GL|ZXXS|CWLC|CWLK|CWLG|ZZL|ZBZL|HDZZL|HDZK|CCRQ|ZSXZQH|ZSXXDZ|ZSYZBM|LXDH|ZZJZZM|ZZXZQH|ZZXXDZ|CLYT|YTSX|SJHM|YQJYQZBFQZ</resultfields></row></shareData>";
        in0 = URLEncoder.encode(in0, "UTF-8");
        String in1 = Constants.IN1;
        String in3 = Constants.IN3;
        String args = "in0" + "=" + in0 + "&" + "in1" + "=" + in1 + "&" + "in2" + "=" + in2 + "&" + "in3" + "=" + in3 + "&"+ "in4" + "&" + "in5";
        String userInfo = userInfoService.getUserInfo(args);
        //根据车牌号未查到信息
        if(userInfo == null){
            return new ResponseData(Response.CODE_OO2, Response.MSG_002);
        }
        return new ResponseData<String>(Response.CODE_000, Response.MSG_000, userInfo);
    }


}
