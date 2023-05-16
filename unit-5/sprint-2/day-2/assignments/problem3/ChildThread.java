package com.problem3;

import java.util.List;
import java.util.Scanner;

public class ChildThread implements Runnable {
	
	int n;	
	private List<String> list;

	public ChildThread(List<String> cities) {
		// TODO Auto-generated constructor stub
		this.list = cities;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the value of n:");
		n = sc.nextInt();
		System.out.println("Enter name of " + n + " cities:");
		
		for (int i=0; i<n; i++) {
			list.add(sc.next());
		}
		sc.close();
	}

}
