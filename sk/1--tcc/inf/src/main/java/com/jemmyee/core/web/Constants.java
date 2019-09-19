package com.jemmyee.core.web;

/**
 * Created by jemmyee
 */
public class Constants {
    /*根路径*/
    public static final String APPROOT="approot";

    /*后台登录验证码*/
    public static final String SESSION_ADMIN_LOGIN_VALIDATE_CODE="session_admin_login_validate_code";

    /*在线管理员*/
    public static final String ONLINE_ADMIN_USER_ID="online_admin_user_id";
    public static final String ONLINE_ADMIN_USER="online_admin_user";

    public static final Integer DEFAULT_PAGE_SIZE=15;

    //测试地址
   // public static final String BASE_URL="http://172.30.8.10:8080/KKPK-API";

    //线上地址
    static final String BASE_URL = "http://172.30.27.30/KKPK-API";

    //测试地址
//    public static final String LM_INF_URL1="http://172.30.8.10:8080/whlm-zjtc-srv";
//    public static final String LM_INF_URL2="http://172.30.8.12:8080/whlm-hustxks";
//    public  static  final  String LM_INF_URL3=" http://172.30.8.10:8080/auth-sso-srv";

    //线上地址
     public static final String LM_INF_URL1="http://172.30.27.30/whlm-zjtc-srv";
     public static final String LM_INF_URL2="http://172.30.27.30/whlm-hustxks";
     public  static  final  String LM_INF_URL3=" http://172.30.27.30/auth-sso-srv";
    public  static  final  String LM_INF_URL4="https://hp.icbc.com.cn:443";
}
