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
 * @create 2022/2/3 10:57
 */
@Data
@ColumnWidth(25)
@ContentStyle(wrapped = true ,shrinkToFit = true)
@HeadFontStyle(bold = true)
public class CookingMonitoringModel {
    /**
     * 区域
     */
    @ExcelProperty("行政区划")
    private String countyname;
    /**
     * 企业名称
     **/
    @ExcelProperty("餐饮企业名称")
    private String corpname;
    /**
     * 设备类型
     * */
    @ExcelProperty("设备类型")
    private String type;
    /**
     * 设备编号
     * */
    @ExcelProperty("设备编号")
    private String number;
    /**
     * 地址
     */
    @ExcelProperty("地址")
    private String address;
    /**
     * 监测时间
     */
    @ExcelProperty("监测时间")
    private Date updateTime2;

    /**
     * 油烟浓度（mg/m3）
     */
    @ExcelProperty("油烟浓度（mg/m3）")
    private BigDecimal oilFume;

    /**
     * 颗粒物浓度（mg/m3）
     */
    @ExcelProperty("颗粒物浓度（mg/m3）")
    private BigDecimal partMatter;

    /**
     * 非甲烷总烃浓度（mg/m3）
     */
    @ExcelProperty("非甲烷总烃浓度（mg/m3）")
    private BigDecimal nonMe;

    /**
     * 风机电流（A）
     */
    @ExcelProperty("风机电流（A）")
    private BigDecimal fan;

    /**
     * 净化器电流（A）
     */
    @ExcelProperty("净化器电流（A）")
    private BigDecimal purifier;

    /**
     * 风机耗电量（kwh）
     */
    @ExcelProperty("风机耗电量（kwh）")
    private BigDecimal power;

    /**
     * 净化器耗电量（kwh）
     */
    @ExcelProperty("净化器耗电量（kwh）")
    private BigDecimal powerCon;

    /**
     * 风机状态
     */
    @ExcelProperty("风机状态")
    private String fanStatus;

    /**
     * 净化器状态
     */
    @ExcelProperty("净化器状态")
    private String puStatus;
}
