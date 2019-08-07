package com.jemmyee.core.utils;

/**
 * Created by Apple on 2017/6/7.
 */
public class DistanceUtil {
    //地球半径
    private static final double EARTH_RADIUS = 6378.137;
    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    public static double GetDistance(double lat1, double lng1, double lat2, double lng2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        System.out.print(s);
        //s = Math.round(s * 10000) / 10000;
        s=Math.round(s*1000);
        System.out.println(s);
        return s;
    }

    public static void main(String[] args){
        double dis=DistanceUtil.GetDistance(30.5634111372,114.2736405784,30.5640601372,114.2755725784);
        System.out.print(dis);

    }
}
