package com.problem1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File f = new File("abc.txt");
		f.createNewFile();
		
		try (PrintWriter pw = new PrintWriter("abc.txt")) {
			pw.println("9876543210");
			pw.println("8876543210");
			pw.println("7876543210");
			pw.println("6876543210");
			pw.println("5876543210");
			pw.println("4876543210");
			pw.println("3876543210");
			pw.println("2876543210");
			pw.println("1876543210");
			pw.println("0876543210");
			
		}
		File f2 = new File("123.txt");
		f2.createNewFile();
		
		BufferedReader br = new BufferedReader(new FileReader("abc.txt"));
		String line = br.readLine();
		
		while(line != null) {
			
			if (line.charAt(0)=='9' || line.charAt(0)=='8' || line.charAt(0)=='7' || line.charAt(0)=='6') {
				System.out.println(line);				
			}
			line = br.readLine();
		}
	}

}
