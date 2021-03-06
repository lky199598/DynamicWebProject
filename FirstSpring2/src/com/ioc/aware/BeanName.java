package com.ioc.aware;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanName implements BeanNameAware, ApplicationContextAware{
	
	private BeanName b;
	private String beanName;
	
	@Override
	public void setBeanName(String arg0) {
		   beanName = arg0;		   
           System.out.println("beanName: "+arg0);		
	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		b = (BeanName) arg0.getBean(beanName);
		System.out.println("Aware: "+arg0.getBean(beanName));
		
	}
	
	
}
