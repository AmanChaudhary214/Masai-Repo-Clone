package com.masai.tightCoupling;

import com.masai.looseCoupling.Gmail;

public class EmailReader implements Gmail {

	public void execute(){
		System.out.println("Reading email...");
	}

	public String getStatus(){
		return "Email read";
	}

	public void stopOperation(){
		System.out.println("Email reading stopped");
	}

	@Override
	public void gmail() {
		// TODO Auto-generated method stub
		execute();
		getStatus();
		stopOperation();
	}	
}
