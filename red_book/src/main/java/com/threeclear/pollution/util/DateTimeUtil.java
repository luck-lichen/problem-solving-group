package com.threeclear.pollution.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateTimeUtil {


	/**
	 * @param startDate
	 * @param endDate
	 * @param
	 * @return 功能：获得时间段内的时间集合
	 */
	public static List<Date> getDateList(Date startDate,Date endDate){
		List<Date> resList=new ArrayList<>();
		if(startDate.before(endDate)||startDate.equals(endDate)){
			while (startDate.before(endDate)){
				resList.add(startDate);
				startDate= CalDateUtil.dateAdd(startDate,"m",15);
			}
			resList.add(endDate);
		}
		return resList;
	}

	/**
	 * @param
	 * @return 功能：获得时间段内的时间日集合
	 */
	public static List<LocalDate> getDateListDay(Date startTime, Date endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTimeStr = sdf.format(startTime);
		String endTimeStr = sdf.format(endTime);
		String startYear = startTimeStr.substring(0,4);
		String startMonth = startTimeStr.substring(5,7);
		String startDay = startTimeStr.substring(8,10);
		String endYear = endTimeStr.substring(0,4);
		String endMonth = endTimeStr.substring(5,7);
		String endDay = endTimeStr.substring(8,10);
		LocalDate startDate = LocalDate.of(Integer.parseInt(startYear), Integer.parseInt(startMonth), Integer.parseInt(startDay));
		LocalDate endDate = LocalDate.of(Integer.parseInt(endYear), Integer.parseInt(endMonth), Integer.parseInt(endDay));
		long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		List<LocalDate> collect = IntStream.iterate(0, i -> i + 1)
				.limit(numOfDaysBetween)
				.mapToObj(i -> startDate.plusDays(i))
				.collect(Collectors.toList());
		collect.add(endDate);
		return collect;
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @param
	 * @return 功能：获得时间段内的时间集合小时
	 */
	public static List<Date> getDateListHour(Date startDate,Date endDate){
		List<Date> resList=new ArrayList<>();
		if(startDate.before(endDate)||startDate.equals(endDate)){
			while (startDate.before(endDate)){
				resList.add(startDate);
				startDate= CalDateUtil.dateAdd(startDate,"H",1);
			}
			resList.add(endDate);
		}
		return resList;
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @param
	 * @return 功能：获得时间段内的时间集合(字符串形式)
	 */
	public static List<String> getDateStrList(Date startDate,Date endDate,String duration){
		List<Date> dateList = null;
		if(duration.equals("6")){
			dateList = getDateListHour(startDate, endDate);
		}
		List<String> res = new ArrayList<>();
		for (int i = 0; i < dateList.size(); i++) {
			String format = DateUtil.format(dateList.get(i), DatePattern.NORM_DATETIME_PATTERN);
			res.add(format);
		}
		return res;
	}

}
