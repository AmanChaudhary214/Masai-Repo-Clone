package com.masai.tightCoupling;

import com.masai.looseCoupling.Gmail;

public class EmailOrganizer implements Gmail {

	public void execute(){
		System.out.println("Organizing email...");
	}

	public String getStatus(){
		return "Email organized";
	}

	public void stopOperation(){
		System.out.println("Email organizing stopped");
	}

	@Override
	public void gmail() {
		// TODO Auto-generated method stub
		execute();
		getStatus();
		stopOperation();
	}	
}
