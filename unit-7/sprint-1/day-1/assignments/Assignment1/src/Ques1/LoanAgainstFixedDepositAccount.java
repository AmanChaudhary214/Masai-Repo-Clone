package Ques1;

public class LoanAgainstFixedDepositAccount extends FixedDepositAccount {

	double loanAmount;
	double loanInterestRate;
	
	
	public LoanAgainstFixedDepositAccount(double loanAmount, double loanInterestRate) {
		super(200000.000, 12.5);
		this.loanAmount = loanAmount;
		this.loanInterestRate = loanInterestRate;
	}
	
	public double calculateTotalPayment() {
		
		double amount = loanAmount + (loanAmount * loanInterestRate) / 100;
		
		amount = (Math.round(amount * 100))/100.0;
		
		return amount;
	}
}
