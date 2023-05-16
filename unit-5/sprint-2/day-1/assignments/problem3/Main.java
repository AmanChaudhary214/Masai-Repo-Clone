package com.problem3;

public class Main extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread tr = new Thread(new Main());
		
		Thread tr1 = new Thread(new T1());
		Thread tr2 = new Thread(new T2(tr1));
		Thread tr3 = new Thread(new T3(tr1));
		
		tr2.setPriority(7);
		tr3.setPriority(3);
		
		tr1.start();
		tr2.start();
		tr3.start();
		
		try {
			tr3.join();
			for (int i=0; i<10; i++) {
				System.out.print(i + " ");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
