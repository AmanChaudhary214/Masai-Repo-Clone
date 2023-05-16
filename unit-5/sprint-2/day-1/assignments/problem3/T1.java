package com.problem3;

public class T1 extends Thread{

	public void run() {
		
		for (int i=201; i<=300; i++) {
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
