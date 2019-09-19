package com.jemmyee.core.web;

/**
 * @author jemmyee@qq.com
 * @create 2017-03-15 15:41
 **/
public interface ResponseData {

    /**
     * 请求服务正常返回
     **/
    String CODE_000000 = "000000";
    String MSG_000000 = "请求成功";

    String CODE_000001 = "000001";
    String MSG_000001 = "请求失败";

    String CODE_000002 = "000002";
    String MSG_000002 = "登录超时^.^";

    String CODE_000003 = "000003";
    String MSG_000003 = "未登录^.^";

    String CODE_000004 = "000004";
    String MSG_000004 = "请求参数错误^.^";

    String CODE_000005 = "000005";
    String MSG_000005 = "没有指定的查询结果^.^";

    String CODE_000006 = "000006";
    String MSG_000006 = "id重复了^.^";
    String CODE_300003 = "300003";
    String MSG_300003 = "平台已有出车记录^.^";
    /**
     * 停车记录
     **/
    String CODE_100001 = "100001";
    String MSG_100001 = "停车场编号错误";

    String CODE_100011 = "100011";
    String MSG_100011 = "联盟无记录或已出车";

    String CODE_100002 = "100002";
    String MSG_100002 = "无记录";
    String CODE_400001= "400001";
    String MSG_400001 = "车牌不能为空";

    /**
     * 请求通知
     **/
    String CODE_200001 = "200001";
    String MSG_200001 = "平台和联盟都推送成功";

    String CODE_200002 = "200002";
    String MSG_200002 = "联盟推送失败";



}
