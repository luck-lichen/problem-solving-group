package com.threeclear.pollution.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lianghaibin
 * @create 2022/2/1 10:21
 */
@Data
@ColumnWidth(25)
@ContentStyle(wrapped = true ,shrinkToFit = true)
@HeadFontStyle(bold = true)
public class CookingFumeDataModel {
    /**
     * 区域
     */
    @ExcelProperty("行政区划")
    private String countyname;
    /**
     * 企业名称
     **/
    @ExcelProperty("企业名称")
    private String corpname;
    /**
     * 设备编号
     * */
    @ExcelProperty("设备编号")
    private String number;
    /**
     * 报警时间
     */
    @ExcelProperty("报警时间")
    private Date updateTime2;
    /**
     * 油烟浓度
     */
    @ExcelProperty("油烟浓度")
    private BigDecimal v4x10;
    /**
     * 颗粒物
     */
    @ExcelProperty("颗粒物")
    private BigDecimal v4x11;
    /**
     * 非甲烷总烃
     */
    @ExcelProperty("非甲烷总烃")
    private BigDecimal v4x12;
    /**
     * 风机开关
     */
    @ExcelProperty("风机开关")
    private String fanSwitch;
    /**
     * 净化器开关
     */
    @ExcelProperty("净化器开关")
    private String puSwitch;

    /**
     * 报警内容
     */
    @ExcelProperty("报警内容")
    private String alarmDetail;

    /**
     * 状态
     */
    @ExcelProperty("状态")
    private String status;

    /**
     * 处置人
     */
    @ExcelProperty("处置人")
    private String disposalUser;

    /**
     * 处理结果
     */
    @ExcelProperty("处理结果")
    private String description;

    /**
     * 报警解除时间
     */
    @ExcelProperty("报警解除时间")
    private String removeTime;
}
