package com.problem3;

public class T3 extends Thread{

	Thread tr;

	public T3(Thread tr) {
	super();
	this.tr = tr;
}

	public void run() {
		try {
			tr.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=601; i<=700; i++) {
			int count = 0;
			for (int j=1; j<=i; j++) {
				if (i%j==0) {
					count++;
				}
			}
			if (count==2) {
				System.out.println(i);
			}
		}
	}
}
