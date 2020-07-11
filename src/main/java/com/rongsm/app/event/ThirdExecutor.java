package com.rongsm.app.event;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rongsimin
 * @date 2020/7/11 17:47
 */
@Component
public class ThirdExecutor implements EventExecutor {
	@Override
	public Set<String> supportTag() {
		Set<String> set = new HashSet<>();
		set.add(EventTagConstant.DELETE);
		set.add(EventTagConstant.INSERT);
		return set;
	}

	@Override
	public void handleEvent(StatusChangedEvent event) {
		System.out.println("third " + event.getContent());
	}
}
