package com.masai.tightCoupling;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GmailUser gu = new GmailUser(new EmailReader());
		
		gu.readEmails();
		System.out.println();gu.sendEmails();
		gu.organizeEmails();
	}

}
