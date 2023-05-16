package com.masai;

public class SimpleInterestTester {
	
	public static void main(String args[]){
        SimpleInterest siOne = new SimpleInterest();
        SimpleInterest siTwo = new SimpleInterest();
        siOne.setValues(1005, 2, 7.5);
        siTwo.setValues(1235.50, 2.5, 8.25);
        System.out.println(siOne.getInterestAmount(1005, 2, 7.5));
        System.out.println(siTwo.getInterestAmount(1235.50, 2.5, 8.25));
    }
}

class SimpleInterest {
	double principle;
	double time;
	double rate;
	
	void setValues(double pa, double tp, double ir){
	    //write code to assign value here
		principle = pa;
		time = tp;
		rate = ir;
	}
	
	double getInterestAmount(double principle, double time, double rate){
	    //write code to computer and return the interest amount rounded to two decimal places
		double interest = (principle*rate*time)/100;
		return (Math.round(interest * 100))/100.0;
	}
}