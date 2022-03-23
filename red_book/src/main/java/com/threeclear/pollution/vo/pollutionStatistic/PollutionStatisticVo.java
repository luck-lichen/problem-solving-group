package com.threeclear.pollution.vo.pollutionStatistic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * @author zhangzhizhao 2022/2/1 23:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollutionStatisticVo {
    /**
     * 第一行,即张家口统计
     */
    private PollutionStatistic head;
    /**
     * 其余行
     */
    private Collection<PollutionStatistic> content;
}
