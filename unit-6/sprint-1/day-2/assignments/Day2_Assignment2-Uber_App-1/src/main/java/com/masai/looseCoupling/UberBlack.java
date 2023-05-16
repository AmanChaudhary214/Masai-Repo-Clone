package com.masai.looseCoupling;

public class UberBlack implements Uber {

	public void startRide(){
		System.out.println("UberBlack ride started");
	}

	public void endRide(){
		System.out.println("UberBlack ride ended");
	}

	public void cancelRide(){
		System.out.println("UberBlack ride cancelled");
	}

	@Override
	public void uber() {
		// TODO Auto-generated method stub
		startRide();
		endRide();
		cancelRide();
	}
}
