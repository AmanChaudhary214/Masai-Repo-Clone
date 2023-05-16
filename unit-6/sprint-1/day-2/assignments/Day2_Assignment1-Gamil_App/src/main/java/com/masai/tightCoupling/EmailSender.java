package com.masai.tightCoupling;

import com.masai.looseCoupling.Gmail;

public class EmailSender implements Gmail {

	public void execute(){
		System.out.println("Sending email...");
	}

	public String getStatus(){
		return "Email sent";
	}

	public void stopOperation(){
		System.out.println("Email sending stopped");
	}

	@Override
	public void gmail() {
		// TODO Auto-generated method stub
		execute();
		getStatus();
		stopOperation();
	}	
}
