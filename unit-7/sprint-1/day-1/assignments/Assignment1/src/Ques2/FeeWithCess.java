package Ques2;

public class FeeWithCess extends FeeExpenses{

	private double cess;

	public FeeWithCess(double tuitionFee, double serviceTax, double cess) {
		super(tuitionFee, serviceTax);
		this.cess = cess;
	}

	@Override
	public double getTotalFee() {
		
		double totalFee = super.getTotalFee() + (super.getTotalFee() * cess/100);
		return totalFee;
	}
}
