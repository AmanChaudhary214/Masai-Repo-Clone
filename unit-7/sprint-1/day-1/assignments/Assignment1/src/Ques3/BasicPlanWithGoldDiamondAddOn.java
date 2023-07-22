package Ques3;

public class BasicPlanWithGoldDiamondAddOn extends BasicPlanWithGoldAddOn{

	double diamondAddOnCharges;

	public BasicPlanWithGoldDiamondAddOn(double subscriptionCharge, int hoursWatched, double goldAddOnCharges,
			double diamondAddOnCharges) {
		super(subscriptionCharge, hoursWatched, goldAddOnCharges);
		this.diamondAddOnCharges = diamondAddOnCharges;
	}


	@Override
	public double getTotalCharges() {
		
		if (hoursWatched < 120) {
			double totalCharges = subscriptionCharge + goldAddOnCharges + diamondAddOnCharges;
			return totalCharges;
		}
		else {
			double totalCharges = subscriptionCharge + goldAddOnCharges + diamondAddOnCharges + .9 * (hoursWatched-120);
			return totalCharges;
		}
	}
	
}
