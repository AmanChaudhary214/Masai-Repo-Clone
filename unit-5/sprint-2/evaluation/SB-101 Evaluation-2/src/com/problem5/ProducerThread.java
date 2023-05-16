package com.problem5;

public class ProducerThread extends Thread{

	Common pc;

	public ProducerThread(Common c1) {
		super();
		this.pc = c1;
	}
	
	@Override
	public void run() {
		int i = 0;
		while(true) {
			pc.produce(i);
			i++;
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
