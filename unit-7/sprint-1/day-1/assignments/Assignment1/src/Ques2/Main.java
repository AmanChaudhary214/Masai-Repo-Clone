package Ques2;

public class Main {

	public static void main(String[] args) {
		
		FeeExpenses fe = new FeeExpenses(25000.00, 12.5);
		System.out.println(fe.getTotalFee());
		
		FeeWithCess fwc = new FeeWithCess(25000.00, 12.5, 7.50);
		System.out.println(fwc.getTotalFee());
		
	}
}
