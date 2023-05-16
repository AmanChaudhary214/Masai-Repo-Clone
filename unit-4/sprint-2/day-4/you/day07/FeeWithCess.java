package com.assignment.day07;

class FeeWithCess extends FeeExpenses{
	private double cess;

	public FeeWithCess(double tutionFee, double serviceTax, double cess) {
		super(tutionFee, serviceTax);
		this.cess = cess;
	}
	
	@Override
	double getTotalFee() {
		double totalFee = super.getTotalFee() + super.getTutionFee()*cess/100;
		return totalFee; 
	}
}
