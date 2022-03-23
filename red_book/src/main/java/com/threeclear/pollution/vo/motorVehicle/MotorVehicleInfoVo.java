package com.threeclear.pollution.vo.motorVehicle;

import lombok.Data;

import java.util.Date;

@Data
public class MotorVehicleInfoVo {

    private String pointId;
    private String pointName;
    private String pointLng;
    private String pointLat;
    private String pointType;
    private String pointAddress;

    //监测线编号
    private String remoteLineNumber;
    //车牌号
    private String carNumber;
    //车牌颜色
    private String carColor;
    //判定结果
    private String judgementRes;
    //监测时间
    private Date monitorTime;
    //车辆类型
    private String carType;
    //燃料类型
    private String fuelType;
    //速度
    private String speed;
    //加速度
    private String acceleration;
    private String vsp;
    //co结果
    private String coResult;
    //co限值
    private String coLimit;
    //no结果
    private String noResult;
    //no限值
    private String noLimit;
    //不透光结果
    private String opacityResult;
    //不透光限值
    private String opacityLimit;
    //co2结果
    private String co2Result;
    //hc结果
    private String hcResult;
    //co co2比率
    private Integer coCo2Rate;
    //no co2比率
    private Integer noCo2Rate;
    //hc co2比率
    private Integer hcCo2Rate;
    //温度
    private String temperature;
    //湿度
    private String humidity;
    //压力
    private String airPressure;
    //风速
    private String windSpeed;
    //风向
    private String windDirection;
    //林格曼黑度
    private String salingerLimit;
    //图片1
    private String pic1;
    //图片2
    private String pic2;
    public MotorVehicleInfoVo(){
        opacityLimit = "-";
        salingerLimit = "-";
    }
}
