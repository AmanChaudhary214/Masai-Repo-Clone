package com.problem5;

public class Common {

	int num;
	boolean flag = true;
	
	public synchronized void produce(int i) {
		
		if (flag) {
			num = i;
			this.notify();
			flag = false;
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized int consume() {
		int sum = 0;
		
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag = true;
		this.notify();
		for (int l=0; l<=num; l++) {
			sum = sum + l;
		}
		return sum;
	}
}
