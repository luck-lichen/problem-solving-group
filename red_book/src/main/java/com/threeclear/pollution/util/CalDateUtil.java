package com.threeclear.pollution.util;
import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ：yanxinY
 * @date ：Created in 2020/8/6 11:05
 * @description：日期工具类
 */
public class CalDateUtil {

	/*
		todo  calendar的创建成本很高
		todo 防止变量污染 线程不安全
	 */
	private static Calendar cal = ThreadLocal.withInitial(()->Calendar.getInstance()).get();

	/**
	 * @author jidengke
	 * @date 2017-6-27 下午3:04:29
	 * @param startDate
	 * @param endDate
	 * @param interval 时间间隔 d天 H小时 ...
	 * @return 功能：获得时间段内的时间集合
	 */
	public static List<Date> getDateList(Date startDate,Date endDate,String interval){
		List<Date> resList=new ArrayList<>();
		if(startDate.before(endDate)||startDate.equals(endDate)){
			while (startDate.before(endDate)){
				resList.add(startDate);
				startDate= CalDateUtil.dateAdd(startDate,interval,1);
			}
			resList.add(endDate);
		}
		return resList;
	}

	public static List<Date> getDateListByDurationCode(Date startDate,Date endDate,String durationCode){
		List<Date> resList=new ArrayList<>();
		if(startDate.before(endDate)||startDate.equals(endDate)){
			while (startDate.before(endDate)){
				resList.add(startDate);
				if (Objects.equals("2", durationCode)){
					startDate= CalDateUtil.dateTimeAdd(startDate,"m",5);
				}else {
					startDate= CalDateUtil.dateTimeAdd(startDate,"h",1);
				}
			}
			resList.add(endDate);
		}
		return resList;
	}

	/**
	 * @author yaoxinghui
	 * @date 2016-5-31 下午5:22:15
	 * @param str
	 * @return 功能：字符串转日期
	 */
	public static Date strToDate(String str,String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * @author yaoxinghui
	 * @date 2016-5-31 下午5:22:29
	 * @param date
	 * @return 功能:日期转字符串
	 */
	public static String dateToStr(Date date, String formatstr) {
		SimpleDateFormat format = new SimpleDateFormat(formatstr);
		String str = format.format(date);
		return str;
	}

	/**
	 * @author jidengke
	 * @date 2017-7-7 下午5:04:29
	 * @param date
	 * @param interval
	 * @param number
	 * @return 功能:日期加减 获得指定时间前后时间
	 */
	public static Date dateAdd(Date date,String interval,int number){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if("y".equals(interval)){
			cal.add(Calendar.YEAR, number);
		}else if("M".equals(interval)){
			cal.add(Calendar.MONTH, number);
		}else if("d".equals(interval)){
			cal.add(Calendar.DATE, number);
		}else if("h".equals(interval)||"H".equals(interval)){
			cal.add(Calendar.HOUR, number);
		}else if("m".equals(interval)){
			cal.add(Calendar.MINUTE, number);
		}else if("s".equals(interval)){
			cal.add(Calendar.SECOND, number);
		}else {
			return null;
		}
		return cal.getTime();
	}

	public static cn.hutool.core.date.DateTime dateTimeAdd(Date date, String interval, int number){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if("y".equals(interval)){
			cal.add(Calendar.YEAR, number);
		}else if("M".equals(interval)){
			cal.add(Calendar.MONTH, number);
		}else if("d".equals(interval)){
			cal.add(Calendar.DATE, number);
		}else if("h".equals(interval)||"H".equals(interval)){
			cal.add(Calendar.HOUR, number);
		}else if("m".equals(interval)){
			cal.add(Calendar.MINUTE, number);
		}else if("s".equals(interval)){
			cal.add(Calendar.SECOND, number);
		}else {
			return null;
		}
		String dateStr = DateUtil.format(cal.getTime(), "yyyy-MM-dd HH:mm:ss");
		return DateUtil.parse(dateStr, "yyyy-MM-dd HH:mm:ss");
	}
}