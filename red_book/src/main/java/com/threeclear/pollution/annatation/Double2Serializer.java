package com.threeclear.pollution.annatation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class Double2Serializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value != null) {
            BigDecimal bigDecimal = new BigDecimal(value.toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
            jsonGenerator.writeString(bigDecimal.toString());
        }
    }
}
