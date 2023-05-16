package com.masai.tightCoupling;

public class UberDriver {

	UberX ux = new UberX();
	UberXL uxl = new UberXL();
	UberBlack ub = new UberBlack();
	
	public void drive(){
		System.out.println("Driver is ready");
		//here it needs Dependencies
		ux.startRide();
		ux.endRide();
		ux.cancelRide();
	}
	
}
