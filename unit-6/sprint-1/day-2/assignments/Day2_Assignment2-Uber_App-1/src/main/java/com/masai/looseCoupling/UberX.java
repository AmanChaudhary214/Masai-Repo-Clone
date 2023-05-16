package com.masai.looseCoupling;

public class UberX implements Uber {

	public void startRide(){
		System.out.println("UberX ride started");
	}

	public void endRide(){
		System.out.println("UberX ride ended");
	}

	public void cancelRide(){
		System.out.println("UberX ride cancelled");
	}

	@Override
	public void uber() {
		// TODO Auto-generated method stub
		startRide();
		endRide();
		cancelRide();
	}
}
