package com.gfg.lecture1;
class A{
	final static int x=30;
	static {
		System.out.println("static");
	}
}
public class Hello {

	
public static void main(String[] args) {
	
System.out.println(A.x);
}
}