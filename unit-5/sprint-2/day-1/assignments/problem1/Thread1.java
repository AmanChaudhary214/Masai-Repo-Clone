package com.problem1;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i=1; i<=10; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
	}

}
