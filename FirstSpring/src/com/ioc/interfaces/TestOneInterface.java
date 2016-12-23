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
	//接口用于隐藏具体实现和实现多态性
	OneInterface oneInterface = super.getBean("oneInterfaceImpl");
	
	System.out.println(oneInterface.hello("我的输入参数"));
}


}
