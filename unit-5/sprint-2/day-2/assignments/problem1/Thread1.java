package com.problem1;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=2; i<=20; i+=2) {
			System.out.println(i);
		}
	}

}