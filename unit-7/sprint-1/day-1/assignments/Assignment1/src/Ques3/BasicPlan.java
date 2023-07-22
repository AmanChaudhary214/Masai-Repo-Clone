package Ques3;

public class BasicPlan {

	double subscriptionCharge;
	int hoursWatched;
	
	public BasicPlan(double subscriptionCharge, int hoursWatched) {
		super();
		this.subscriptionCharge = subscriptionCharge;
		this.hoursWatched = hoursWatched;
	}

	public double getSubscriptionCharge() {
		return subscriptionCharge;
	}

	public int getHoursWatched() {
		return hoursWatched;
	}
	
	public double getTotalCharges() {
		
		if (hoursWatched < 45) {
			double totalCharges = subscriptionCharge;
			return totalCharges;
		}
		else {
			double totalCharges = subscriptionCharge + 1.5 * (hoursWatched-45);
			return totalCharges;
		}
	}
	
}
