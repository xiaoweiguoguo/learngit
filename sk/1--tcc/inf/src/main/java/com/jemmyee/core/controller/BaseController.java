package com.jemmyee.core.controller;

import com.jemmyee.core.web.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * 所有Controller的基类
 * @author jemmyee
 **/
public class BaseController {

    public Integer getOnlineUserID(HttpServletRequest request) {
        if (request.getSession().getAttribute(Constants.ONLINE_ADMIN_USER_ID) != null) {
            Integer id=(Integer) request.getSession().getAttribute(Constants.ONLINE_ADMIN_USER_ID);
            return id;
        } else {
            return null;
        }
    }

    /**
     * @Description:得到访问IP 解决配置了Apache,Squid等反向代理软件中无法获取真实IP的情况
     * @author:jemmyee@gmail.com
     */
    public String getIP(HttpServletRequest req)
    {
        String ip = req.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }
        return ip;
    }

}
