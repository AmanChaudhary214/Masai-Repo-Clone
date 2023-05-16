package com.problem3;

import java.util.ArrayList;
import java.util.List;

public class Main implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//4
		List<String> cities =  new ArrayList<>();
		
		Thread t1 = new Thread(new ChildThread(cities));
		
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String element:cities) {
			System.out.println(element);
			Thread.sleep(500);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
