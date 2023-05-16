package com.masai.looseCoupling;

public class EmailReader {

	public void execute(){
		System.out.println("Reading email...");
	}

	public String getStatus(){
		return "Email read";
	}

	public void stopOperation(){
		System.out.println("Email reading stopped");
	}
}
