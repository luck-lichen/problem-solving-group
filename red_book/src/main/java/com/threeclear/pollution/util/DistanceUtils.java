package com.threeclear.pollution.util;

import java.util.Objects;

/**
 * @author lianghaibin
 * @create 2022/1/27 11:32
 */
public class DistanceUtils {

    /**
     * 地球半径,单位 km
     */
    private static final double EARTH_RADIUS = 6378.137;

    /**
     * 根据经纬度，计算两点间的距离
     *
     * @param longitude1 第一个点的经度
     * @param latitude1  第一个点的纬度
     * @param longitude2 第二个点的经度
     * @param latitude2  第二个点的纬度
     * @return 返回距离 是否在范围内
     */
    public static boolean getDistance(double longitude1, double latitude1, double longitude2, double latitude2,double radius) {
        if (Objects.isNull(longitude1) || Objects.isNull(latitude1)||Objects.isNull(longitude2) || Objects.isNull(latitude2)){
            return false;
        }
        // 纬度
        double lat1 = Math.toRadians(latitude1);
        double lat2 = Math.toRadians(latitude2);
        // 经度
        double lng1 = Math.toRadians(longitude1);
        double lng2 = Math.toRadians(longitude2);
        // 纬度之差
        double a = lat1 - lat2;
        // 经度之差
        double b = lng1 - lng2;
        // 计算两点距离的公式
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2)));
        // 弧长乘地球半径, 返回单位: 千米
        s =  s * EARTH_RADIUS;
        return s<radius;
    }

    /**
     * 根据经纬度，计算两点间的距离
     *
     * @param maxLon 经度最大值
     * @param maxLat  纬度最大值
     * @param minLon 经度最小值
     * @param minLat  纬度最小值
     * @param lon 目标点的经度
     * @param lat  目标点的纬度
     * @return 返回距离 是否在范围内
     */
    public static boolean getScope(double maxLon, double maxLat, double minLon, double minLat,double lon,double lat) {
        boolean b =true;
        b = (lon>minLon && lon<maxLon) && (lat>minLat && lat<maxLat);
        return b;
    }

}
