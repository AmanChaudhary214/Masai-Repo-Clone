package GPay;

public class TransactionService {

	AccountDetailsDAO accDetails;

	public void setAccDetails(AccountDetailsDAO accDetails) {
		this.accDetails = accDetails;
	}
	
	public double calcTransactionFees() {
		
		double balance = accDetails.getAccountDetails();
		double updatedBalance = balance - 0.001 * balance;
		
		return updatedBalance;
	}
}
