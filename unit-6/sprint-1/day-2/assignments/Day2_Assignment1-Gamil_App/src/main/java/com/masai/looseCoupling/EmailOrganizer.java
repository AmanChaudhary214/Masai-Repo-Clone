package com.masai.looseCoupling;

public class EmailOrganizer {

	public void execute(){
		System.out.println("Organizing email...");
	}

	public String getStatus(){
		return "Email organized";
	}

	public void stopOperation(){
		System.out.println("Email organizing stopped");
	}	
}
