package com.threeclear.pollution.entity;

import lombok.Data;

/**
 * 餐饮油烟设备信息(cyyy_dev_info)表实体类
 *
 * @author lichen
 * @since 20220107
 */
@Data
public class CyyyDevInfo {
    /*
    * 设备 ID
    * */
    private String id;
    /*
     * 设备编号
     * */
    private String number;
    /*
     * 设备别名
     * */
    private String alias;
    /*
     * 地址
     * */
    private String address;
    /*
     * 安装地址经纬度
     * */
    private String location;
    /*
     * 经度
     * */
    private String longitude;
    /*
     * 纬度
     * */
    private String latitude;
    /*
     * 商户名称
     * */
    private String corpname;
    /*
     * 门店头牌
     * */
    private String signboard;
    /*
     * 商户统一社会信用代码
     * */
    private String socialunifiedcreditcode;
    /*
     * 设备状态。0 未知、1 正常连接、2 响应超时、3 断开离线、 4 监测报警、5 设备异常
     * */
    private Integer status;
    /*
     *
     * */
    private Integer netstatus;

    //当日是否报警且未解除
    private String warmingFlag;


}

