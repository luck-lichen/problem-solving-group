package com.threeclear.pollution.dto.base;

import cn.hutool.core.date.CalendarUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zjw
 * 严禁修改
 */
@Data
public class BeginEndTimeDto {
    /**
     * 开始时间
     */
    //@ValidDateTime
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 结束时间
     */
    //@ValidDateTime
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public BeginEndTimeDto() {
    }


    //public BeginEndTimeDto(String startTime, String endTime) {
    //    this.startTime = startTime;
    //    this.endTime = endTime;
    //}
    //
    //public BeginEndTimeDto(Date startTime, Date endTime) {
    //    this.startTime = DateUtil.format(startTime, DatePattern.NORM_DATETIME_PATTERN);
    //    this.endTime = DateUtil.format(endTime, DatePattern.NORM_DATETIME_PATTERN);
    //}

    //public BeginEndTimeDto(Calendar startTime, Calendar endTime) {
    //    this.startTime = DateUtil.format(startTime.getTime(), DatePattern.NORM_DATETIME_PATTERN);
    //    this.endTime = DateUtil.format(endTime.getTime(), DatePattern.NORM_DATETIME_PATTERN);
    //}

//    public String check() {
//        String msg = "";
//        if (this == null) {
//            msg = "开始时间参数,结束时间参数不能为空";
//        } else if (StrUtil.isBlank(this.getStartTime())) {
//            msg = "开始时间参数不能为空";
//        } else if (StrUtil.isBlank(this.getEndTime())) {
//            msg = "结束时间参数不能为空";
//        }
//        return msg;
//    }


}
