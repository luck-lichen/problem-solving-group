package com.threeclear.pollution.vo.pollutionStatistic;

import lombok.Data;

import java.util.Objects;

/**
 * @author zhangzhizhao 2022/2/1 14:25
 */
@Data
public class PollutionParams {
    /**
     * 废气
     */
    private Double smoke;
    /**
     * 烟尘
     */
    private Double dust;
    /**
     * 氮氧化物
     */
    private Double no;
    /**
     * 二氧化硫
     */
    private Double so2;
    /**
     * 一氧化碳
     */
    private Double co;

    public void sum(PollutionParams value) {
        if (Objects.nonNull(value.smoke)) {
            if (this.smoke == null) {
                this.smoke = value.smoke;
            } else {
                this.smoke += value.smoke;
            }
        }
        if (Objects.nonNull(value.dust)) {
            if (this.dust == null) {
                this.dust = value.dust;
            } else {
                this.dust += value.dust;
            }
        }
        if (Objects.nonNull(value.no)) {
            if (this.no == null) {
                this.no = value.no;
            } else {
                this.no += value.no;
            }
        }
        if (Objects.nonNull(value.so2)) {
            if (this.so2 == null) {
                this.so2 = value.so2;
            } else {
                this.so2 += value.so2;
            }
        }
        if (Objects.nonNull(value.co)) {
            if (this.co == null) {
                this.co = value.co;
            } else {
                this.co += value.co;
            }
        }
    }

    public PollutionParams get() {
        this.co=0d;
        this.so2=0d;
        this.dust=0d;
        this.no=0d;
        this.smoke=0d;
        return this;
    }
}
