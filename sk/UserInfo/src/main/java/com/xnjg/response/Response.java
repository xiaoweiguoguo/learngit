package com.xnjg.response;

/**
 * ==========================
 * Created with IntelliJ IDEA.
 *
 * @Auth: weixw
 * @Date: 2019/4/24 11:23
 * @Version 1.0.0
 * ==========================
 */
public interface Response {

    String CODE_000 = "000";
    String MSG_000 = "请求成功";

    String CODE_001 = "001";
    String MSG_001 = "参数错误";

    String CODE_OO2 = "002";
    String MSG_002 = "用户信息不存在，请输入正确的车牌号";
}
