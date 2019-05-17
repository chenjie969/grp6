package com.opensymphony.workflow.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware{
	private static ApplicationContext cxt ;

	@Override
	public void setApplicationContext(ApplicationContext cxt) throws BeansException {
		SpringContextUtil.cxt = cxt;
	}
	
	public static Object getBean(String name) throws BeansException {
		return cxt.getBean(name);
	}
}
