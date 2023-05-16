package com.problem1;

public class Thread2 implements Runnable {

	Thread t1;
	
	public Thread2(Thread t1) {
		super();
		this.t1 = t1;
	}


	@Override
	public void run() {
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		for (int i=1; i<=19; i+=2) {
			System.out.println(i);
		}
	}

}
