package com;

class access1
{
	private int a;
	public int b;
	int c;
	protected int d;
	
	public access1(int a, int b, int c, int d)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;				
	}
}




class access2 extends access1
{
	public access2()
	{
		super(1,2,3,4);
	}

}


public class access extends access2{
	private int g=7;
		
	public void show()
	{
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
	
	
	public static void main(String[] args)
	{
		Integer a  = 6;
		
		Integer b = new Integer(6);
		Integer c = new Integer(6);
		
		System.out.println(a==b);//false
		System.out.println(b==c);//false
		
		
	}

}