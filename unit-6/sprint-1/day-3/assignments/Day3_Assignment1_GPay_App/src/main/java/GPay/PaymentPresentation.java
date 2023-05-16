package GPay;

public class PaymentPresentation {

	TransactionService tService;

	public void settService(TransactionService tService) {
		this.tService = tService;
	}
	
	public void payment() {

		System.out.println("Current balance: " + tService.calcTransactionFees());
	}
}
