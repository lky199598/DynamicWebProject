package com.ioc.interfaces;

import org.junit.Test;

import com.ioc.base.UnitTestBase;



public class TestOneInterface extends  UnitTestBase{
	
public TestOneInterface()
{
	super("classpath*:spring-ioc.xml");
}


@Test
public void test()
{
	//�ӿ��������ؾ���ʵ�ֺ�ʵ�ֶ�̬��
	OneInterface oneInterface = super.getBean("oneInterfaceImpl");
	
	System.out.println(oneInterface.hello("�ҵ��������"));
}


}