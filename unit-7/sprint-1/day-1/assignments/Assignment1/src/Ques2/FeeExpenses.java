package Ques2;

public class FeeExpenses {

	private double tuitionFee;
	private double serviceTax;
	
	
	public FeeExpenses(double tuitionFee, double serviceTax) {
		super();
		this.tuitionFee = tuitionFee;
		this.serviceTax = serviceTax;
	}
	
	public double getTotalFee() {
		
		double totalFee = tuitionFee + (serviceTax * tuitionFee/100);
		return totalFee;
	}
}
