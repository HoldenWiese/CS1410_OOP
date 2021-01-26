package a1;

public class DrivingCostCalculator {
	
	public static double calculateTripCost(double milesToDrive, double milesPerGallon, double dollarsPerGallon) {
		double cost = milesToDrive * (dollarsPerGallon / milesPerGallon);
		System.out.println(cost);
		return cost;
	}
	
	public static void main(String[] args) {
		
		//variables for computation
		String car1 = "Toyota Camry";
		double car1Efficiency = 30.0;
		String car2 = "Ford F-150";
		double car2Efficiency = 15.5;
		double gasCost = 3.25;
		double tripMiles = 31.5;
		
		calculateTripCost(tripMiles, car2Efficiency, gasCost);
	}
	
	

}
