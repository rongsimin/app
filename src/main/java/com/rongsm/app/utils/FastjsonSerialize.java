package com.rongsm.app.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @author rongsimin
 * @date 2020/7/11 17:10
 */
@Component
public class FastjsonSerialize implements SerializeInterface {
	@Override
	public String serialize(Object object) {
		return JSONObject.toJSONString(object);
	}
}
