package com.problem1;

public class Virat implements Runnable {

	Thread tr;
	public Virat(Thread t2) {
		// TODO Auto-generated constructor stub
		this.tr = t2;
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
		int sum = 0;
		for (int i=1; i<=20; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
	}

}