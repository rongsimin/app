package com.rongsm.app.event;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rongsimin
 * @date 2020/7/11 17:43
 */
@Getter
@Setter
public class StatusChangedEvent {
	/**
	 * 消息一般都会有个topic属性，用来过滤感兴趣的事件，在本例子中没用到而已
	 */
	private String topic;

	private String tag;

	private String content;
}
