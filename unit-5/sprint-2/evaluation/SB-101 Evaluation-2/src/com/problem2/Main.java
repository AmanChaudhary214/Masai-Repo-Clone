package com.problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable FirstThread = () -> {
			
			try {
				PrintWriter pw = new PrintWriter(new File("student.txt"));
				pw.println("Anuj 56.25 77.58");
				pw.println("Bharat 66.25 57.58");
				pw.println("Chaman 70.25 66.74");
				pw.println("Dhanush 58.25 95.74");
				pw.println("Garv 58.62 95.74");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Thread t1 = new Thread(FirstThread, "first thread");
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		Callable<String> SecondThread = () -> {
			String maxName = "";
			double maxPer = 0.0;
			try {
				Scanner sc = new Scanner(new File("student.txt"));
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] arr = line.split(" ");
					double temp = Double.parseDouble(arr[1]);
					if (temp>maxPer) {
						maxPer = temp;
						maxName = arr[0];
					}
				}
				sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			return maxName;
		};
		
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> f1 = executor.submit(SecondThread);
		
		
		Callable<Double> ThirdThread = () -> {
			double total = 0.00;
			int n = 0;
			try {
				Scanner sc = new Scanner(new File("student.txt"));
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] arr = line.split(" ");
					double temp = Double.parseDouble(arr[2]);
					total = total + temp;
					n++;
				}
				sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			return (total/n);
		};
		
		
		Future<Double> f2 = executor.submit(ThirdThread); 
		
		try {
			String maxName = f1.get();
			System.out.println(maxName);
			
			double avgAtt = f2.get();
			System.out.println(avgAtt);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
	}

}
