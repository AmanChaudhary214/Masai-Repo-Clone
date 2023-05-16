package com.problem1;

public class Main implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2(t1));
		
		t1.start();
		t2.start();
		
		
	}


}
