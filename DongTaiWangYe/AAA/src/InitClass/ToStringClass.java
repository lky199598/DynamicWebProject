package InitClass;

import java.util.HashMap;

class Test {
	private String s;

	public Test() {
		System.out.println("Test");
		s = "Constructed";
	}

	public String toString() {
		return s+" toString";
	}

}

public class ToStringClass {
    
	private Test t  = new Test();
	boolean bo;
	char c;
	
	byte b;
	short s;
	int i;
	long l;
	
	float f;
	double d;
	
	public String toString()
	{
		return "t= "+t+",  boolean="+bo+", char="+c+", byte="+b+", short="+s+", "
				+ "int="+i+", long="+l+", float="+f+", double="+d;
	}
    
	public static void main(String[] args) {
		
	}
}


