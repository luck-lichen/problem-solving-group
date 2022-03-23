package com.threeclear.pollution.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 餐饮油烟报警数据实体类
 */
@Data
public class CookingFumeDataVo {
	/*
	 * id
	 * */
	private String id;
	/*
	* 地址
	* */
	private String address;
	/*
	 * 企业名称
	 * */
	private String corpname;
	/*
	 * 设备编号
	 * */
	private String number;
	/**
	 * 报警时间
	 */
	private Date updateTime2;
	/**
	 * 油烟浓度
	 */
	private BigDecimal v4x10;
	/**
	 * 颗粒物
	 */
	private BigDecimal v4x11;
	/**
	 * 非甲烷总烃
	 */
	private BigDecimal v4x12;

	/**
	 * 非甲烷总烃
	 */
	private BigDecimal v4x4;
	/**
	 * 非甲烷总烃
	 */
	private BigDecimal v4x5;
	/**
	 * 非甲烷总烃
	 */
	private BigDecimal v4x8;
	/**
	 * 非甲烷总烃
	 */
	private BigDecimal v4x9;
	/**
	 * 风机开关
	 */
	private BigDecimal v0x1;
	/**
	 * 净化器开关
	 */
	private BigDecimal v0x2;

	/**
	 * 风机开关
	 */
	private String fanSwitch;
	/**
	 * 净化器开关
	 */
	private String puSwitch;

	/**
	 * 报警内容
	 */
	private String alarmDetail;
	/**
	 * 区域
	 */
	private String countyname;
	/**
	 * 区域编码
	 */
	private String countycode;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 处置人
	 */
	private String disposalUser;

	/**
	 * 处理结果
	 */
	private String description;

	/**
	 * 报警解除时间
	 */
	private String removeTime;
}
