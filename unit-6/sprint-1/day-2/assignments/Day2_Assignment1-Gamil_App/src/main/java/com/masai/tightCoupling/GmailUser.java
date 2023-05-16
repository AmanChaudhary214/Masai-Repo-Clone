package com.masai.tightCoupling;

import com.masai.looseCoupling.Gmail;

public class GmailUser {
	
	Gmail g;

	public GmailUser(Gmail g) {
		super();
		this.g = g;
	}

	public void readEmails(){
		//here it needs EmailReader Dependency
		System.out.println("Reading emails...");
		g.gmail();
		//Use execute(), getStatus(), stopOperation() of EmailReader
	}
	
	public void sendEmails(){
		//here it needs EmailSender Dependency
		System.out.println("Sending emails...");
		g.gmail();
		//Use execute(), getStatus(), stopOperation() of EmailSender
	}
	
	public void organizeEmails(){
		//here it needs EmailOrganizer Dependency
		System.out.println("Organizing emails...");
		g.gmail();
		//Use execute(), getStatus(), stopOperation() of EmailOrganizer
	}
}
