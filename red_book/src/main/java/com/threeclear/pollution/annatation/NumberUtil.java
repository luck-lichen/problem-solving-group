package com.threeclear.pollution.annatation;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 邵海楠
 * @date 2022/1/15 10:57
 * @description
 */
@Data
public class NumberUtil {
    /**
     * @param value 需要科学计算的数据
     * @param digit 保留的小数位
     * @return 功能：四舍六入五成双计算法
     * @author mayuan
     * @time 2015-8-20 上午9:30:23
     */
    public static String sciCal(double value, int digit) {
        String result = "-999";
        try {
            double ratio = Math.pow(10, digit);
            boolean isNegative = false;
            if (value < 0) {
                isNegative = true;
                value = Math.abs(value);
            }
            double _num = value * ratio;
            double mod = _num % 1;
            double integer = Math.floor(_num);
            double returnNum;
            if (mod > 0.5) {
                returnNum = (integer + 1) / ratio;
            } else if (mod < 0.5) {
                returnNum = integer / ratio;
            } else {
                returnNum = (integer % 2 == 0 ? integer : integer + 1) / ratio;
            }
            BigDecimal bg = new BigDecimal(Double.toString(returnNum));
            result = bg.setScale(digit, BigDecimal.ROUND_HALF_UP).toString();
            if (isNegative) {
                result = "-" + result;
            }
        } catch (RuntimeException e) {
            throw e;
        }
        BigDecimal bg = new BigDecimal(result);
        return bg.toString();
    }

    /**
     * 保留n位小数, 可能会发生数值溢出问题
     *
     * @param d     原始数据
     * @param digit 保留小数位
     * @return 保留digit位小数后的数字d
     * @author zhangzhizhao
     */
    public static Double standardDouble(Double d, int digit) {
        if (d == null) {
            return null;
        }
        if (digit < 0) {
            throw new IllegalArgumentException("Negative decimal places cannot be preserved");
        }
        double pow = Math.pow(10, digit);
        return Math.round(d * pow) / pow;
    }

    public static Double standardDouble(Double d) {
        return standardDouble(d, 2);
    }
}
