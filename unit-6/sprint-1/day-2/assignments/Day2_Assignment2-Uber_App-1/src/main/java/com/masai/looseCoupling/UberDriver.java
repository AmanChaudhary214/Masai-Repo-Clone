package com.masai.looseCoupling;

public class UberDriver {

	Uber u;
	
	public UberDriver(Uber u) {
		super();
		this.u = u;
	}

	public void drive(){
		System.out.println("Driver is ready");
		//here it needs Dependencies
		u.uber();
	}
	
}
