package me.cof.googlehash;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public final static int ROWS;
	public final static int COLUMNS;
	public final static int NUM_VEHICLES;
	public final static int NUM_RIDES;
	public final static int BONUS_VALUE;
	public final static int MAX_STEPS;
	
	List<Vehicle> vehicles = new ArrayList<Vehicle>();
	List<Ride> rides = new ArrayList<Ride>();
	
	public static void main(String[] args) {
	}
	
	void inputFile(String filePath){
		Scanner input;
		
		input = new Scanner(new File(filePath));
		
		// Read the first line - always the city setup
		String line = input.nextLine();
		String[] properties = line.split(" ");
		ROWS = Integer.parseInt(properties[0]);
		COLUMNS = Integer.parseInt(properties[1]);
		NUM_VEHICLES = Integer.parseInt(properties[2]);
		NUM_RIDES = Integer.parseInt(properties[3]);
		BONUS_VALUE = Integer.parseInt(properties[4]);
		MAX_STEPS = Integer.parseInt(properties[5]);
		
		while (input.hasNextLine()){
			line = input.nextLine();
			String[] values = line.split(" ");
			rides.add(new Ride());
		}
		
		
	}
}
