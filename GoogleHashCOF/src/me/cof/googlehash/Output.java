package me.cof.googlehash;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {
	//Attributes
	private List<Vehicle> vehicles;
	private String filepath;
	
	//Constructor
	public Output(List<Vehicle>vehicles, String filepath) {
		this.vehicles = vehicles;
		this.filepath = filepath; //For testing: "examples/output.txt"
	}
	
	//Main file generator
	public void generateFile() {
		try {
			//Create a new output file
            File file = new File(filepath);
            if (!file.exists()) {
                file.createNewFile();
            }
            //Create a file writer
            FileWriter writer = new FileWriter(file);
            
            //Iterate through the vehicles in the array
            for (Vehicle car : vehicles) {
            	
            	//Set first value as the number of rides
            	String data = Integer.toString(car.getAmountOfRides());
            	
            	//Iterate through the rides the vehicles have completed
            	for (Ride ride: car.getCompletedRides()) {
            		data += " ";
            		data += ride.getRideNum();
            	}
            	
            	//Adds a newline and writes the data to the file
            	data += "\n";
            	writer.write(data);
            }
            
            //End of generator
            writer.close();
        } catch (IOException e) {
        	//Catch and print exception
            e.printStackTrace();
        }	
	}
}