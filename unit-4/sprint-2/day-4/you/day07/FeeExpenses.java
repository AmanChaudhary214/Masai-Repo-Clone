package com.assignment.day07;

public class FeeExpenses {
	private double tutionFee;
	private double serviceTax;
	
	public FeeExpenses(double tutionFee, double serviceTax) {
		this.tutionFee = tutionFee;
		this.serviceTax = serviceTax;
	}
	
	public double getTutionFee() {
		return tutionFee;
	}

	double getTotalFee() {
		double totalFee = tutionFee + (serviceTax*tutionFee)/100;
		return totalFee; 
	}
}
