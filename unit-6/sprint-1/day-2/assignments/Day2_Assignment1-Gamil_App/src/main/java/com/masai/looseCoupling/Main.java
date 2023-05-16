package com.masai.looseCoupling;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GmailUser gu = new GmailUser();
		gu.readEmails();
		gu.sendEmails();
		gu.organizeEmails();
	}

}
