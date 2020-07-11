package com.rongsm.app.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

/**
 * @author rongsimin
 * @date 2020/7/11 17:08
 */
@Component
public class JacksonSerialize implements SerializeInterface {

	@Override
	public String serialize(Object object) {
		try {
			return new ObjectMapper().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
}
