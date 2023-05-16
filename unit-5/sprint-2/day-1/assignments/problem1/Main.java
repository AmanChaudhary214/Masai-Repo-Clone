package com.problem1;

public class Main implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread tr = new Thread(new Main());
		tr.setName("Akshay");
		
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		Thread tr1 = new Thread(t1);
		Thread tr2 = new Thread(t2);
		
		tr1.setName("Salman");
		tr2.setName("Hrithik");
		
		tr1.start();
		tr2.start();
		
		try {
			tr2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i=0; i<10; i++) {
			System.out.println(tr.getName());
		}
	}


}
