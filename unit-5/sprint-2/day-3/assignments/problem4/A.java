package com.problem4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class A{
	
	public static void main(String ags[]) throws InterruptedException, ExecutionException{
		ExecutorService es = Executors.newFixedThreadPool(3);		//----- (1)
		Runnable r = () -> {};
		Callable<String> c = () -> "B";
		
		for(int i = 0; i <= 8; i++){
			Future f = es.submit(c);		//----- (2)
			System.out.print(f.get() != null?"A":"");		//----- (3)   "9 times"
		}
		
		for(int i = 9; i <= 10; i++){
			Future<String> f = es.submit(c);
			String result = f.get();
			System.out.print(result != null?result:"C");		//----- (4) "B"
		}
		
		es.shutdown();		//----- (5)
	}
}

//(1) Write code here to create a fixed thread pool of 3 threads?
//(2) Write appropriate method call here to execute the task defined for Runnable interface?
//(3) How many times "A" will be printed on screen?
//(4) What will be output of this statement
//(5) Write appropriate method call here to make sure that no new task should be submitted but existing tasks finish.