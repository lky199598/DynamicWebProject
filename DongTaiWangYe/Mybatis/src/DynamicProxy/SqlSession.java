package DynamicProxy;

import java.lang.reflect.Proxy;

public class SqlSession {

	public <T> T getMapper(Class<T> type)
	{
		System.out.println("通过 接口的Class 从  代理工厂Map 取出对应的 代理工厂");
		System.out.println("通过代理工厂 实例化 一个代理类");
		System.out.println("用这个代理类 生成一个 代理实例 返回出去");
		return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new MapperProxy());
	}
}
