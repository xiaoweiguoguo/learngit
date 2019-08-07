package com.jemmyee.core.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名称                ：StringUtil
 * 编写者                  : wanyixing
 * 编写日期                : 2017-9-7
 * 编写时间                : 10:32
 * 程序功能（类）描述       ：<p>
 */
public class StringUtil {
    private static Log logger = LogFactory.getLog(StringUtil.class);

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @param flag
     * @return
     */
    public static boolean isNotNullStr(String str, boolean flag) {
        if (str == null)
            return false;
        if (flag && str.length() == 0)
            return false;
        return true;
    }
    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNotNullStr(String str) {
        if (str == null) {
            return true;
        }
        if (str.length() == 0) {
            return true;
        }
        return false;
    }
    public static String extractString(String targetString) {
        String[] target = targetString.split("\\|");
        String extract = target[1];
        return extract;
    }
    public static List<String> stringToList(String str){
        List<String> list = new ArrayList<String>();
        if(null != str && !"".equals(str)){
            String strs[] = str.split(",");
            for (String string : strs) {
                list.add(string);
            }
        }
        return list;
    }
}
