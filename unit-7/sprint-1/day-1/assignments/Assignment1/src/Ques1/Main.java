package Ques1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FixedDepositAccount fda = new FixedDepositAccount(120000.500, 10.5);
		System.out.println(fda.calculateMaturityValue());
		
		LoanAgainstFixedDepositAccount lfda = new LoanAgainstFixedDepositAccount(100000.000, 20.0);
		System.out.println(lfda.calculateTotalPayment());
		
	}

}
