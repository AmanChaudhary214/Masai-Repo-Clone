package com.problem5;

public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ProducerConsumer pc = new ProducerConsumer();
//		Thread t1 = new Thread(new ProducerThread(pc));
//		Thread t2 = new Thread(new ConsumerThread(pc));
		
		Common c1 = new Common();
		
		ProducerThread t1 = new ProducerThread(c1);
		ConsumerThread t2 = new ConsumerThread(c1);
		
		t1.start();
		t2.start();
		
	}

}
