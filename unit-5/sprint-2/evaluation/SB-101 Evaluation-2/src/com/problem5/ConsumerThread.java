package com.problem5;

public class ConsumerThread extends Thread{

	Common pc;

	public ConsumerThread(Common c1) {
		// TODO Auto-generated constructor stub
		super();
		this.pc = c1;
	}
	
	@Override
	public void run() {
		while(true) {
			int i = pc.consume();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
