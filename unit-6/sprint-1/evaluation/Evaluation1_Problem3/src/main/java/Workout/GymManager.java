package Workout;

import java.util.Map;

public class GymManager {

	private Map<WorkoutProgram, Member> gymPrograms;

	public void setGymPrograms(Map<WorkoutProgram, Member> gymPrograms) {
		this.gymPrograms = gymPrograms;
	}
	

	public void initialize() {
		System.out.println("inside init-method");
	}
	
	public void shutDown() {
		System.out.println("inside shutdown-method");
	}
	
	public void displayDetails() {
		System.out.println();
		System.out.println(gymPrograms);
	}
	
}
