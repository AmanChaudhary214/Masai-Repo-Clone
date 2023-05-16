package com.problem2;

class Salman extends Thread{
	
	Common c;

	public Salman(Common c) {
		super();
		this.c = c;
	}
	
	@Override
	public void run() {
		c.even();
	}
}

class Hitrik extends Thread{
	
	Common c;
	
	public Hitrik(Common c) {
		super();
		this.c = c;
	}
	
	@Override
	public void run() {
		c.odd();;
	}
}


class Common {
	
	boolean flag = true;
	
	synchronized public void even() {
		  
		for(int i = 0;i<=20;i++) {
			if (i%2==0) {
				System.out.println(i+" ");
				flag = false;
				
				notify();
				try {
					wait();
				}catch(InterruptedException ex) {
					
				}
			}
		}
	}	
	
	synchronized public void odd() {
		if(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i = 0;i<=20;i++) {
			if(i%2!=0) {
				System.out.println(i+" ");
				notify();
				
				try {
					wait();
				}catch(InterruptedException ex) {
					
				}
			}
		}	
	}	
}

public class Main {
	
	public static void main(String[] args) {
		
		Common c = new Common();
		
		Salman sk = new Salman(c);
		Hitrik hr = new Hitrik(c);
		
		sk.start();
		hr.start();
		
		try {
			sk.join();
			hr.join();
		} catch (InterruptedException e) {
			
		}
	}
}