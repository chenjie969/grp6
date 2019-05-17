package com.zjm.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * 自定义处理JSON对象内Long数据格式
 * @author mashuo add 20170419
 *@JsonDeserialize(using = LongJsonDeserializer.class)
 */
public class LongJsonDeserializer extends JsonDeserializer<Long>{
	@Override
	public Long deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
		return arg0.getLongValue();
	}
}
