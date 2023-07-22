package Ques1;

public class FixedDepositAccount {

	double depositAmount;
	double fdInterestRate;
	
	
	public FixedDepositAccount(double depositAmount, double fdInterestRate) {
		super();
		this.depositAmount = depositAmount;
		this.fdInterestRate = fdInterestRate;
	}
	
	public double calculateMaturityValue() {
		
		double maturityValue = depositAmount * (1 + fdInterestRate/100);
		
		maturityValue = (Math.round(maturityValue * 100))/100.0;
		
		return maturityValue;
	}
}
