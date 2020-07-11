package com.rongsm.app.event;

import java.util.Set;

/**
 * @author rongsimin
 * @date 2020/7/11 17:45
 * 用来处理事件
 */

public interface EventExecutor {
	/**
	 * 支持处理的tag类型
	 */
	Set<String> supportTag();

	/**
	 * 对事件进行处理
	 */
	void handleEvent(StatusChangedEvent event);
}
