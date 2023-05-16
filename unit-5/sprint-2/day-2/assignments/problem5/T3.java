package com.problem5;

public class T3 implements Runnable {

	A a;
	String name;
	public T3(A a, String string) {
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