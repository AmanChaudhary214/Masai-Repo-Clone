package Ques3;

public class BasicPlanWithGoldAddOn extends BasicPlan {

	double goldAddOnCharges;

	public BasicPlanWithGoldAddOn(double subscriptionCharge, int hoursWatched, double goldAddOnCharges) {
		super(subscriptionCharge, hoursWatched);
		this.goldAddOnCharges = goldAddOnCharges;
	}

	public double getGoldAddOnCharges() {
		return goldAddOnCharges;
	}
	
	@Override
	public double getTotalCharges() {
		
		if (hoursWatched < 75) {
			double totalCharges = subscriptionCharge + goldAddOnCharges;
			return totalCharges;
		}
		else {
			double totalCharges = subscriptionCharge + goldAddOnCharges + 1.2 * (hoursWatched-75);
			return totalCharges;
		}
	}
	
}
