package com.rongsm.app.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author rongsimin
 * @date 2020/7/11 17:15
 */
@Component
public class MoocSpringContainer implements ApplicationListener<ContextRefreshedEvent> {
	private ApplicationContext applicationContext;

	private static MoocSpringContainer moocSpringContainer;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (applicationContext == null) {
			applicationContext = event.getApplicationContext();
		}
		moocSpringContainer = this;
	}

	public static MoocSpringContainer getInstance(){
		return moocSpringContainer;
	}

	public <T> T getBean(Class<T> clazz){
		return applicationContext.getBean(clazz);
	}
}
