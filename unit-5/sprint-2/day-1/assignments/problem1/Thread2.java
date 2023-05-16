package com.problem1;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int product = 1;
		for (int i=1; i<=10; i++) {
			product = product*i;
		}
		System.out.println(product);
	}

}
