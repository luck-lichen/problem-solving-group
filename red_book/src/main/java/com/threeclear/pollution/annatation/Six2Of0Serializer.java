package com.threeclear.pollution.annatation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 四舍五入刘成双保留整数位
 */

public class Six2Of0Serializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value != null) {
            String v = NumberUtil.sciCal((Double) value, 0);
            //BigDecimal bigDecimal = new BigDecimal(value.toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
            jsonGenerator.writeString(v);
        }
    }
}
