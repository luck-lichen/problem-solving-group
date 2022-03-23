package com.threeclear.pollution.util;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author lianghaibin
 * @create 2022/2/4 16:52
 */
public class DecimalUtil {

    public static Double reservedDecimalPlace(Double dou,int place){
        if (Objects.isNull(dou)){
            return 0.000;
        }
        BigDecimal bg = new BigDecimal(dou);
        double v = bg.setScale(place, BigDecimal.ROUND_HALF_UP).doubleValue();
        return v;
    }

    /**
     * 计算同比
     * @param val1
     * @param val2
     * @return
     */
    public static BigDecimal handelTb(BigDecimal val1,BigDecimal val2,int dec){
        if(null ==val1||null ==val2||val2.compareTo(BigDecimal.ZERO) ==0){
            return null;
        }
        return val1.subtract(val2).divide(val2,4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100)).setScale(dec,BigDecimal.ROUND_HALF_EVEN);
    }

    public static BigDecimal handelBigdecimal(BigDecimal val,int dec){
        if(null ==val){
            return null;
        }
        return val.setScale(dec,BigDecimal.ROUND_HALF_EVEN);
    }
}
