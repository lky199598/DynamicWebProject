package com.imooc.test.aop.aspectj;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.imooc.aop.aspectj.biz.MoocBiz;
import com.ioc.base.UnitTestBase;

/*
BlockJUnit4ClassRunner则是Juint4默认的运行器，叫成Block是因为他是按 
顺序一个一个执行测试用例的，Junit4中没有提供实现多线程执行的运行器
*/
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAspectJ extends UnitTestBase{
	
	public TestAspectJ() {
		super("classpath:spring-aop-aspectj.xml");
	}
	
	@Test
	public void test() {
		MoocBiz biz = getBean("moocBiz");
		biz.save("This is test.");
	}
	
}
