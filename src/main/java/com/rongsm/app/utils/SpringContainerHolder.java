package com.rongsm.app.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author rongsimin
 * @date 2020/7/11 17:31
 */
@Component
public class SpringContainerHolder implements ApplicationContextAware {

	private static ApplicationContext ac;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ac = applicationContext;
	}

	public static ApplicationContext getAc(){
		return ac;
	}


}
