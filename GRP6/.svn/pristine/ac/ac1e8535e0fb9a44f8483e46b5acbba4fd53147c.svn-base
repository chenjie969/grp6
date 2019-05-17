package com.zjm.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 自定义处理JSON对象内Long数据格式
 * @author mashuo add 20170419
 *@JsonSerialize(using = LongJsonSerializer.class)
 */
public class LongJsonSerializer extends JsonSerializer<Long>{
	@Override
	public void serialize(Long value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
	            jsonGenerator.writeString(value.toString());  
		
	}
}
