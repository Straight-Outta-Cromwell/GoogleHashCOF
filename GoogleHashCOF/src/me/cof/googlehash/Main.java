package me.cof.googlehash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int ROWS;
	public static int COLUMNS;
	public static int NUM_VEHICLES;
	public static int NUM_RIDES;
	public static int BONUS_VALUE;
	public static int MAX_STEPS;
	
	public static int POINTS = 0;
	public static int CURRENT_TIME = 0;
	public static int COMPLETED_RIDES = 0;

	static List<Vehicle> vehicles = new ArrayList<Vehicle>();
	public static List<Ride> rides = new ArrayList<Ride>();

	public static void main(String[] args) {
		inputFile("examples/c_no_hurry.in");
		
		// Init all of the cars
		for (int i = 0; i < NUM_VEHICLES; i++){
			vehicles.add(new Vehicle());
		}
		
		while(CURRENT_TIME < MAX_STEPS && COMPLETED_RIDES < NUM_RIDES){
			//System.out.println("Current Turn: " + CURRENT_TIME);
			for (Vehicle v : vehicles){
				v.MoveTowardsTarget();
			}
			System.out.println("Remaining Rides: " + rides.size());
			CURRENT_TIME++;
		}
		
		System.out.println("Amount of Points: " + POINTS);
		System.out.println("Remaining Rides: " + rides.size());
	}

	static void inputFile(String filePath) {
		Scanner input = null;

		try {
			input = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Read the first line - always the city setup
		String line = input.nextLine();
		String[] properties = line.split(" ");
		ROWS = Integer.parseInt(properties[0]);
		COLUMNS = Integer.parseInt(properties[1]);
		NUM_VEHICLES = Integer.parseInt(properties[2]);
		NUM_RIDES = Integer.parseInt(properties[3]);
		BONUS_VALUE = Integer.parseInt(properties[4]);
		MAX_STEPS = Integer.parseInt(properties[5]);

		while (input.hasNextLine()) {
			line = input.nextLine();
			String[] values = line.split(" ");
			int[] startPoint = { Integer.parseInt(values[0]), Integer.parseInt(values[1]) };
			int[] endPoint = { Integer.parseInt(values[2]), Integer.parseInt(values[3]) };

			rides.add(new Ride(Integer.parseInt(values[4]), Integer.parseInt(values[5]), startPoint, endPoint));
		}

	}
}
