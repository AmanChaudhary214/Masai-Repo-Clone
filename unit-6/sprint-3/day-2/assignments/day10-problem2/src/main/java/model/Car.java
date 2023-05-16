package model;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {
	
	public void start() {
		System.out.println("Car started...");
	}

	public void vehicleMethod() {
		// TODO Auto-generated method stub
		start();
	}

}