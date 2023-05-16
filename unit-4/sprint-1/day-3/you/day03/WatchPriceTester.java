package com.assignment.day03;
import java.util.Scanner;


public class WatchPriceTester{
	
	  public static void main(String args[]){
	    WatchPriceCalculator wcOne = new WatchPriceCalculator();
	    
	    //for watch type = Titan, gender = "female", age = 25
	    System.out.println(wcOne.getWatchPrice("Titan", 25, "female"));
	    
	    //for watch type = Rolex, gender = "male", age = 61
	    System.out.println(wcOne.getWatchPrice("Rolex", 61, "male"));
	    
	    //for watch type = Rolex, gender = "female", age = 61
	    System.out.println(wcOne.getWatchPrice("Rolex", 61, "female"));
	    
	    //for watch type = Rolex, gender = "female", age = 61
	    System.out.println(wcOne.getWatchPrice("Titan", 25, "male"));
	  }
	}
class WatchPriceCalculator{
	double getWatchPrice(String watchType, int age, String gender){
		//code to computer and return the price of watch up to two decimal places
		int cp1 = 7999;
		int cp2 = 10999;
		double p1 = 12.5/100;
		double p2 = 13.5/100;
		double g1 = 7.5/100;
		double g2 = 12.5/100;
		
		double total_bill = 0;
		
		if (age>=60) {
			if (gender == "female") {
				if (watchType == "Titan") {
					double total = cp1 + cp1*(p1+g1);
					total_bill = total - 0.05*total;
				}
				else if (watchType == "Rolex") {
					double total = cp2 + cp2*(p2+g2);
					total_bill = total - 0.05*total;
				}
			}
			else if (gender == "male") {
				if (watchType == "Titan") {
					double total = cp1 + cp1*(p1+g1);
					total_bill = total - 0.03*total;
				}
				else if (watchType == "Rolex") {
					double total = cp2 + cp2*(p2+g2);
					total_bill = total - 0.03*total;
				}
			}
		}
		else {
			if (gender == "female") {
				if (watchType == "Titan") {
					double total = cp1 + cp1*(p1+g1);
					total_bill = total - 0.02*total;
				}
				else if (watchType == "Rolex") {
					double total = cp2 + cp2*(p2+g2);
					total_bill = total - 0.02*total;
				}
			}
			else if (gender == "male") {
				if (watchType == "Titan") {
					double total = cp1 + cp1*(p1+g1);
					total_bill = total;
				}
				else if (watchType == "Rolex") {
					double total = cp2 + cp2*(p2+g2);
					total_bill = total;
				}
			}
		}
		return total_bill;
	}
}