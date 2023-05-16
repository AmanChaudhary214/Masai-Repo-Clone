package com.masai.looseCoupling;

public class UberXL implements Uber {

	public void startRide(){
		System.out.println("UberXL ride started");
	}

	public void endRide(){
		System.out.println("UberXL ride ended");
	}

	public void cancelRide(){
		System.out.println("UberXL ride cancelled");
	}

	@Override
	public void uber() {
		// TODO Auto-generated method stub
		startRide();
		endRide();
		cancelRide();
	}
}
