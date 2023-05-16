package com.masai.looseCoupling;

public class GmailUser {
	
	EmailSender es = new EmailSender();
	EmailReader er = new EmailReader();
	EmailOrganizer eo = new EmailOrganizer();

	public void readEmails(){
		//here it needs EmailReader Dependency
		System.out.println("Reading emails...");
		er.execute();
		System.out.println(er.getStatus());
		er.stopOperation();
		//Use execute(), getStatus(), stopOperation() of EmailReader
	}
	
	public void sendEmails(){
		//here it needs EmailSender Dependency
		System.out.println("Sending emails...");
		es.execute();
		System.out.println(es.getStatus());
		es.stopOperation();
		//Use execute(), getStatus(), stopOperation() of EmailSender
	}
	
	public void organizeEmails(){
		//here it needs EmailOrganizer Dependency
		System.out.println("Organizing emails...");
		eo.execute();
		System.out.println(eo.getStatus());
		eo.stopOperation();
		//Use execute(), getStatus(), stopOperation() of EmailOrganizer
	}
}
