package InitClass;

import InitClass.Person.Home;


public class Person {

	static class Home {
		Home() {
		}

		void A() {
			System.out.println("这是静态内部类的实例方法");
		}

		static void B() {
			System.out.println("这是静态内部类的类方法");
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