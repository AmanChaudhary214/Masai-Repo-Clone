package model;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {
	
	public void start() {
		System.out.println("Bike started...");
	}

	public void vehicleMethod() {
		// TODO Auto-generated method stub
		start();
	}

}
