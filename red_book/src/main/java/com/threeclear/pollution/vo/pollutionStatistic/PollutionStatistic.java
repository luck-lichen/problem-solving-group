package com.threeclear.pollution.vo.pollutionStatistic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangzhizhao 2022/2/1 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollutionStatistic {
    /**
     * 行政区划/企业
     */
    private String name;
    /**
     * 行政区划/企业id
     */
    private String psId;
    /**
     * 排放量均值/合计
     */
    private PollutionValue value;
    /**
     * 对比基准
     */
    private PollutionValue standardValue;
    /**
     * 减排量
     */
    private PollutionParams reductionValue;
    /**
     * 减排比例
     */
    private PollutionParams reductionPercent;
}
