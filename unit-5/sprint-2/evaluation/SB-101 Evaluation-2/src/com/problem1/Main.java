package com.problem1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new Dhoni());
		Thread t2 = new Thread(new Rohit(t1));
		Thread t3 = new Thread(new Virat(t2));
		
		t1.setPriority(10);
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
