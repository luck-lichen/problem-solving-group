package com.threeclear.pollution.util;



import com.threeclear.pollution.StartUpApplication;
import org.springframework.boot.SpringApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Miracle
 */
public class DateUtil {
    public static final String DATE_FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATA_FORMAT_YYYY_MM_DD ="yyyy-MM-dd";
    public static final String DATE_FORMAT_LAST = "yyyy-MM-dd 23:59:59";
    /**
     * @param date
     * @param interval
     * @param number
     * @return 功能:日期加减 获得指定时间前后时间
     */
    public static Date dateAdd(Date date, String interval, int number) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if ("y".equals(interval)) {
            cal.add(Calendar.YEAR, number);
        } else if ("M".equals(interval)) {
            cal.add(Calendar.MONTH, number);
        } else if ("d".equals(interval)) {
            cal.add(Calendar.DATE, number);
        } else if ("h".equals(interval) || "H".equals(interval)) {
            cal.add(Calendar.HOUR, number);
        } else if ("m".equals(interval)) {
            cal.add(Calendar.MINUTE, number);
        } else if ("s".equals(interval)) {
            cal.add(Calendar.SECOND, number);
        } else {
            return null;
        }
        return cal.getTime();
    }
    /**
     * @param specifiedHour 日期字符串
     * @param format        格式
     * @param hour          数值 负数为前几小时，正数为后几小时
     * @return 功能：计算指定时间前或后几小时时间
     * @author yaoxinghui
     * @date 2016-6-3 下午4:05:58
     */
    public static String getSpecifiedHour(String specifiedHour, String format, int hour) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = simpleDateFormat.parse(specifiedHour);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.add(c.HOUR, hour);
        String dayBefore = simpleDateFormat.format(c.getTime());
        return dayBefore;
    }
    /**
     * 获取两个日期之间所有的日期
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param format    目标格式
     * @return list
     */
    public static List<String> getDayListBetweenDate2(Date startTime, Date endTime, String format) {
        List<String> list = new ArrayList<>();
        list.add(dateToStr(startTime, format));
        Calendar calendar = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calendar.setTime(startTime);
        while (true) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calendar.add(Calendar.DATE, 1);
            // 测试此日期是否在指定日期之后
            if (endTime.after(calendar.getTime())) {
                list.add(dateToStr(calendar.getTime(), format));
            } else {
                break;
            }
        }
        list.add(dateToStr(endTime, format));
        return list;
    }
    public static List<String> getTwoDaysDay(String dateStart, String dateEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> dateList = new ArrayList<String>();
        try{
            Date dateOne = sdf.parse(dateStart);
            Date dateTwo = sdf.parse(dateEnd);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateTwo);

            dateList.add(dateEnd);
            while(calendar.getTime().after(dateOne)){ //倒序时间,顺序after改before其他相应的改动。
                calendar.add(Calendar.DAY_OF_MONTH, -1);
                dateList.add(sdf.format(calendar.getTime()));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return dateList;
    }
    /**
     * @Author zhaoms
     * @Description 获取时间字符串
     * @Date 2019/6/10 11:43
     * @Param []
     * @return java.lang.String
     **/
    public static String getDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * @param specifiedDay 指定日期
     * @param format       格式
     * @param day          数值 负数为前几天，正数为后几天
     * @return 功能：计算指定日期前几天或后几天日期
     * @author yaoxinghui
     * @date 2016-6-3 下午4:00:10
     */
    public static String getSpecifiedDay(String specifiedDay, String format, int day) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = simpleDateFormat.parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        c.add(c.DATE, day);
        String dayBefore = simpleDateFormat.format(c.getTime());
        return dayBefore;
    }


    /**
     * 获取同比日期
     * @param specifiedDay
     * @return
     */
    public static String getTbDate(String specifiedDay, String formatstr) {
        if(specifiedDay.contains("02-29")){
            return getSpecifiedDay(specifiedDay,formatstr,-365);
        }
        //获取年份字段
        String year =specifiedDay.substring(0,4);
        String moonday =specifiedDay.substring(4);
        return (Integer.parseInt(year)-1)+moonday;
    }

    public static String dateToStr(Date date, String formatstr) {
        SimpleDateFormat format = new SimpleDateFormat(formatstr);
        String str = format.format(date);
        return str;
    }

    public static Date strToDate(String strDate, String sourceFormat) {
        SimpleDateFormat format = new SimpleDateFormat(sourceFormat);
        Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static Date getDate(Date date,int num) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_MONTH, num);
        return ca.getTime();
    }

    public static void main(String[] args) {
        String xx ="2020-02-29 00:00:00";
        System.out.println(getTbDate(xx,DATE_FORMAT_TIME));
    }

}

