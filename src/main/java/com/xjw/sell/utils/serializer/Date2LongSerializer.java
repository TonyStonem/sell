package com.xjw.sell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * 2020/7/28 9:40
 *
 * @author <a href="1521975316@qq.com">xjw</a>
 * @record:
 */
public class Date2LongSerializer  extends JsonSerializer<Date>{

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(date.getTime() / 1000);
    }

}
