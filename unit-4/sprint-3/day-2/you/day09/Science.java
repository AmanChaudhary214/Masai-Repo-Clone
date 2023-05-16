package com.assignment.day09;

public abstract class Science {
	private static int counter;
	private String registrationNumber;
	private float physicsTheoryMarks;
	private float physicsPracticalMarks;
	private float chemistryTheoryMarks;
	private float chemistryPracticalMarks;

	static{
		counter = 0;
	}

	Science(String registrationPrefix, float physicsTheoryMarks, float physicsPracticalMarks, float chemistryTheoryMarks, float chemistryPracticalMarks){
    //write code to set instance variables
	}

	generate required setter and getter methods
	abstract public double getPercentage();
}
