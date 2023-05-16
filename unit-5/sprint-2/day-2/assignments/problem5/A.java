package com.problem5;

public class A {

	public void sayHello(String name){
		synchronized (this) {
			System.out.print("Welcome :");
			try{
				Thread.sleep(2000);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(name);
		}
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A a = new A();
		
		Thread t1 = new Thread(new T1(a, "aman"));
		Thread t2 = new Thread(new T2(a, "hemant"));
		Thread t3 = new Thread(new T3(a, "karan"));
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
