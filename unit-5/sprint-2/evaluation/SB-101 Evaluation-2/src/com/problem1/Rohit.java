package com.problem1;

public class Rohit implements Runnable {

	Thread tr;
	public Rohit(Thread t1) {
		// TODO Auto-generated constructor stub
		this.tr = t1;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			tr.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int product = 1;
		for (int i=1; i<=10; i++) {
			product = product * i;
		}
		System.out.println(product);
	}

}