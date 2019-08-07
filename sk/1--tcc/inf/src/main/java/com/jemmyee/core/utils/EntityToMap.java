package com.jemmyee.core.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/13.
 */
public class EntityToMap {
    /**
     * 实体类对象转换成Map
     * @param obj
     * @return
     */
    public static Map<String, Object> ConvertObjToMap(Object obj) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        if (obj == null)
            return null;
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                try {
                    Field f = obj.getClass().getDeclaredField(
                            fields[i].getName());
                    f.setAccessible(true);
                    Object o = f.get(obj);
                    reMap.put(fields[i].getName(), o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return reMap;
    }
    public static String  getParam(Map<String,Object> map){
        String param = "";

        for (String key : map.keySet()) {
//                param += "&" + key + "=" + map.get(key);
            if(map.get(key)!=null){
                param += "&" + key + "=" + map.get(key);
            }
        }
//        param = param.substring(1, param.length() - 1);
        return param;
    }
}
