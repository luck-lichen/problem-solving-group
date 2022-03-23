package com.threeclear.pollution.vo.motorVehicle;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class InspectionVo {
    private String id;
    /**
     * 监控点编号
     * */
    @ExcelProperty("监控点编号")
    private String pointId;
    /**
     * 监控点名称
     * */
    @ExcelProperty("监控点名称")
    private String pointName;
    /**
     * 车牌
     * */
    @ExcelProperty("车牌")
    private String carNumber;
    /**
     * 车牌颜色
     * */
    @ExcelProperty("车牌颜色")
    private String CNColor;
    /**
     * 检测方法
     * */
    @ExcelProperty("检测方法")
    private String inspectionMethod;
    /**
     * co
     * */
    @ExcelProperty("co")
    private String co;
    /**
     * no
     * */
    @ExcelProperty("no")
    private String no;
    /**
     * 不透光度
     * */
    @ExcelProperty("不透光度")
    private String opacity;
    /**
     * 判定结果
     * */
    @ExcelProperty("判定结果")
    private String judgementRes;

    /**
     * 判定结果 解释
     * */
    @ExcelIgnore
    private String judgementResFlag;
    /**
     * 判定结果 解释App
     * */
    @ExcelIgnore
    private String judgementResult;

    /**
     * 数据类型
     * */
    @ExcelProperty("数据类型")
    private String dataType;
    /**
     * 检测时间
     * */
    @ExcelProperty("检测时间")
    private Date monitorTime;
    /**
     * 区域编码
     * */
    @ExcelProperty("区域编码")
    private String areaCode;
    /**
     * 区域名称
     * */
    @ExcelProperty("区域名称")
    private String areaName;
    /**
     * 报警类型
     * */
    @ExcelProperty("报警类型")
    private String alarmType;
}
