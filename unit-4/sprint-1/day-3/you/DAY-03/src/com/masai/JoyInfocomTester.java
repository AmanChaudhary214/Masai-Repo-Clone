package com.masai;

public class JoyInfocomTester {
	
	public static void main(String args[]){
	    JoyInfocom joy = new JoyInfocom();
	    System.out.println(joy.getBillAmount(true, true, true));
	    System.out.println(joy.getBillAmount(true, true, false));
	    System.out.println(joy.getBillAmount(true, false, false));
	  }
}

class JoyInfocom{
	  double getBillAmount(boolean usingCallService, boolean usingDataService, boolean usingSMSService){
	    //write code to return bill amount up to two decimal places
		  double bill = 0;
		  if (usingCallService==true && usingDataService==true && usingSMSService==true) {
			  bill = 300+125+50;
		  }
		  else if (usingCallService==false && usingDataService==true && usingSMSService==true) {
			  bill = 125+50;
		  }
		  else if (usingCallService==true && usingDataService==false && usingSMSService==true) {
			  bill = 300+50;
		  }
		  else if (usingCallService==true && usingDataService==true && usingSMSService==false) {
			  bill = 300+125;
		  }
		  else if (usingCallService==false && usingDataService==false && usingSMSService==true) {
			  bill = 50;
		  }
		  else if (usingCallService==true && usingDataService==false && usingSMSService==false) {
			  bill = 300;
		  }
		  else if (usingCallService==false && usingDataService==true && usingSMSService==false) {
			  bill = 125;
		  }
		  else {
			  bill = 0;
		  }
		  return bill;
	  }
	}