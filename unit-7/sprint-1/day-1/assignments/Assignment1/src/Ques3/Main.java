package Ques3;

public class Main {

	public static void main(String[] args) {

		BasicPlan bp = new BasicPlan(99.00, 65);
		System.out.println(bp.getTotalCharges());
		
		BasicPlanWithGoldAddOn gp = new BasicPlanWithGoldAddOn(99.00, 95, 50.00);
		System.out.println(gp.getTotalCharges());
		
		BasicPlanWithGoldDiamondAddOn dp = new BasicPlanWithGoldDiamondAddOn(99.000, 150, 50.00, 40.00);
		System.out.println(dp.getTotalCharges());

	}

}
