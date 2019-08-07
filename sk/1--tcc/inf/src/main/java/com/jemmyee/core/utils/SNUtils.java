package com.jemmyee.core.utils;

/**
 * @author jemmyee@qq.com
 **/
public class SNUtils {
    public static long getID(int workerId,int datacenterId){
        IdWorker iw = new IdWorker(workerId,datacenterId);
        return iw.nextId();
    }
}
