package InitClass;

import InitClass.Person.Home;


public class Person {

	static class Home {
		Home() {
		}

		void A() {
			System.out.println("���Ǿ�̬�ڲ����ʵ������");
		}

		static void B() {
			System.out.println("���Ǿ�̬�ڲ�����෽��");
		}
	}
}

class Output {
	public static void main(String[] args) {

	    Home h = new Home();
	    h.A();
	    h.B();

		Person.Home.B();
	}
}