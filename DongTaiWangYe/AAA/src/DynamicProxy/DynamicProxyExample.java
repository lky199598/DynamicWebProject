package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/*
 * ���ȴ���ί������󣬽����Թ��캯���������������������������ProxyHandler�л���Java���䷽ʽ���ø�ί�����Ӧ�ķ�����
 * Ȼ��ʹ��Java��������е�Proxy.newProxyInstance��ʽ����һ��������ʵ����
 * ������ʵ����Ҫָ����ʵ���������������Ҫʵ�ֵĽӿ�(��Ŀ��ӿ�)���Լ���������ʵ���ӿڵ��õĴ�������
 * ��󣬵��ô�����Ŀ��ӿڷ���ʱ�����Զ�����ת���������������е�invoke�����ڣ�
 * invoke�����ڲ�ʵ��Ԥ��������ί���෽�����ã��º������߼���
 */
public class DynamicProxyExample {
	public static void main(String[] args){
		 ConcreteClass c=new ConcreteClass();//Ԫ����(����������),����ί�������
		 InvocationHandler ih=new ProxyHandler(c);//����ʵ���ĵ��ô�������
		 
		 //����һ��ʵ��ҵ��ӿڵĴ�����,���ڷ���ҵ����(������ģʽ)��
		 
		 //����һ��ָ���ӿڵĴ�����ʵ�����ýӿڿ��Խ���������ָ�ɵ�ָ���ĵ��ô���������ProxyHandler��
		 
		 TargetInterface targetInterface=
			 (TargetInterface)Proxy.newProxyInstance(c.getClass().getClassLoader(),c.getClass().getInterfaces(),ih);
		 
		 //���ô����෽��, Javaִ��InvocationHandler�ӿڵķ���.
		 int i=targetInterface.targetMethodA(5);
		 System.out.println(i);
		 System.out.println();
		 
		 int j=targetInterface.targetMethodB(15);
		 System.out.println(j);
	}
}