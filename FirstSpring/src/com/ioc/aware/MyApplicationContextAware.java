package com.ioc.aware;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;

public class MyApplicationContextAware implements ApplicationContextAware{
@Override
public void setApplicationContext(
		org.springframework.context.ApplicationContext arg0)
		throws BeansException {	
	System.out.println("MyApplicationContextAware: "+arg0.getBean("myApplicationContextAware").hashCode());	
}
}
