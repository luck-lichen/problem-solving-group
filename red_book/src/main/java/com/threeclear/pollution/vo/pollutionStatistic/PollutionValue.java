package com.threeclear.pollution.vo.pollutionStatistic;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhangzhizhao 2022/2/1 14:25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PollutionValue extends PollutionParams {
    /**
     * 四项污染物均值/总量
     */
    private Double value;
    /**
     * 最大值
     */
    private Double max;
    /**
     * 最大值日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date maxDate;
    /**
     * 最大值对应日废气量
     */
    private Double maxDateSmoke;

    @Override
    public PollutionValue get() {
        super.get();
        this.max=0d;
        this.maxDateSmoke=0d;
        this.value=0d;
        return this;
    }
}
