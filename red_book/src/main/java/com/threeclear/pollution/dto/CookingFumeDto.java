package com.threeclear.pollution.dto;


import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.threeclear.baseweb.annotation.ValidDateTime;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 餐饮油烟DTO
 * @author lichen
 */
@Data
public class CookingFumeDto {
    /*
    * 开始时间
    * */
    private String startTime;
    /*
     * 结束时间
     * */
    private String endTime;
    /*
     * 企业名称
     * */
    private String corpname;
    /*
     * 行政区划(多选)
     * */
    private String countyCode;

    /*
     * 行政区划
     * */
    private List<String> countyCodes;

    /*
     * 页容量
     * */
    private int size;
    /*
     * 页码
     * */
    private int current;

    /*
     * 设备编号
     * */
    private String number;

    /*
     * 报警时间
     * */
    private String alarmTime;

    /*
     * 监测时间
     * */
    private String monitorTime;

    /*
     * 通路
     * */
    private String passageway;

    /*
     * 设备名称
     * */
    private String equipmentName;

    private List<String> statuses;

    /*
     * 企业id
     * */
    private String companyId;

    private boolean order;

    private String sortCode;

}
