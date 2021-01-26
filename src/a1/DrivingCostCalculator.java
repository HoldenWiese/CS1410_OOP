/*
 * CS1410 - Assignment 1: Driving Cost Calculator by Holden Wiese 
 * */

package a1;

public class DrivingCostCalculator {
	
	// This method takes parameters to calculate the cost of a trip.
	public static double calculateTripCost(double milesToDrive, double milesPerGallon, double dollarsPerGallon) { 
		// This line is the formula for computing cost.
		double cost = milesToDrive * (dollarsPerGallon / milesPerGallon); 
		// This line returns the computed double value stored in the cost variable.
		return cost;
	}

	// This method prints a string of info about the driving cost based on car and distance.
	public static void reportDrivingCost(String carModel, double tripDistance, double tripCost) {
		// This line reduces digits after the decimal to two.
		String dollarFormat = String.format("%.2f", tripCost);
		// This line uses string concatenation to print to console. Use of variable allow the statement to change.
		System.out.println(
				"For a " + carModel + ", a trip of " + tripDistance + " miles would cost $" + dollarFormat + ".");
	}

	public static void main(String[] args) {
		// variables needed for computation and report.
		String car1 = "Toyota Camry";
		double car1Efficiency = 30.0;
		String car2 = "Ford F-150";
		double car2Efficiency = 15.5;
		double gasCost = 3.25;
		double tripMiles = 31.5;

		// Here we calculate the trip cost for 2 unique vehicles and store it in a variable.
		double car1TripCost = calculateTripCost(tripMiles, car1Efficiency, gasCost);
		double car2TripCost = calculateTripCost(tripMiles, car2Efficiency, gasCost);

		// With the trip costs calculated we can display the info in our console using our report method.
		reportDrivingCost(car1, tripMiles, car1TripCost);
		reportDrivingCost(car2, tripMiles, car2TripCost);
	}
}
