package com.rongsm.app.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author rongsimin
 * @date 2020/7/11 17:52
 * EventHandler来屏蔽对三个底层具体实现类的调用的
 */
@Component
public class EventHandler implements ApplicationListener<ContextRefreshedEvent> {

	/**
	 *缓存的是tag和EventExecutor的对应关系，这样看到某个tag事件，就能让具体的事件执行器去处理了
	 */
	private final Map<String, Set<EventExecutor>> executorMap = new HashMap<>();

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		synchronized (executorMap) {
			ApplicationContext ac = event.getApplicationContext();
			Map<String, EventExecutor> map = ac.getBeansOfType(EventExecutor.class);
			if (map != null && !map.isEmpty()) {
				for (EventExecutor eventExecutor : map.values()) {
					Set<String> tags = eventExecutor.supportTag();
					for (String tag : tags) {
						if (executorMap.containsKey(tag)) {
							executorMap.get(tag).add(eventExecutor);
						} else {
							Set<EventExecutor> set = new HashSet<>();
							set.add(eventExecutor);
							executorMap.put(tag, set);
						}
					}
				}
			}
		}
	}

	public void handleEvent(StatusChangedEvent event) {
		executorMap.get(event.getTag()).forEach(it -> it.handleEvent(event));
	}
}
