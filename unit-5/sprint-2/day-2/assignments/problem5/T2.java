package com.problem5;

public class T2 implements Runnable {

	A a;
	String name;
	public T2(A a, String string) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.name = string;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		a.sayHello(name);
	}

}