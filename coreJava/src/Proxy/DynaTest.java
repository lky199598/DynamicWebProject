package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

interface IHello1{
	/**
	 * ҵ�񷽷�
	 * 
	 * @param str
	 */
	void sayHello(String str);
}

/*
 * Ŀ������룺
 */
class Hello1 implements IHello1{
	@Override
	public void sayHello(String str) {
		System.out.println("hello " + str);
	}
}


interface ILogger{
	void start(Method method);
	void end(Method method);
}
/*
 * ������
 */
class DLogger implements ILogger {
	@Override
	public void start(Method method) {
		System.out.println(new Date()+"  " + method.getName()
				+ ":say hello start...");
	}

	@Override
	public void end(Method method) {
		System.out.println(new Date() +"  "+method.getName() + " :say hello end");
	}
}

class DynaProxyHello1 implements InvocationHandler {
	// Ŀ�����
		private Object target;
	// ���ö���
	private Object ivoke;
	

	public Object bind(Object target, Object ivoke) {
		this.target = target;
		this.ivoke = ivoke;
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
				this.target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		
		// ����õ������ߵ�ʵ��
		Class clazz = ivoke.getClass();
		// ����õ������ߵ�Start����
		Method start = clazz.getDeclaredMethod("start",
				new Class[] { Method.class });
		// ����ִ��start����
		start.invoke(ivoke, new Object[]{ method});
		
		// ִ��Ҫ���������ԭ������
		result=method.invoke(this.target, args);
		
		//����õ������ߵ�end����
		Method end = clazz.getDeclaredMethod("end",
				new Class[] { Method.class });
		//����ִ��end����
		end.invoke(ivoke, new Object[] { method });
		return result;
	}
}

public class DynaTest {
	public static void main(String[] args) {		
		IHello1 hello = (IHello1)new DynaProxyHello1().bind(new Hello1(),
				new DLogger());// ���������Ҫ��־���ܣ���ʹ�ô�����
		// IHello hello = new Hello();//������ǲ���Ҫ��־������ʹ��Ŀ����
		hello.sayHello("����");
	}
}