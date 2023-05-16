package com.masai.looseCoupling;

public class EmailSender {

	public void execute(){
		System.out.println("Sending email...");
	}

	public String getStatus(){
		return "Email sent";
	}

	public void stopOperation(){
		System.out.println("Email sending stopped");
	}
}
