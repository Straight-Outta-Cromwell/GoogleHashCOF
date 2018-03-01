package me.cof.googlehash;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Output {
	//Attributes
	List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private String filepath;
	
	//Constructor
	public Output(ArrayList<Vehicle>vehicles, String filepath) {
		this.vehicles = vehicles;
		this.filepath = filepath;
	}
	
	//Main file generator
	public File generateFile() {
		File f = new File(filepath);
		
		for (int i = 0; i > vehicles.size(); i++) {
			
		}
		
		return f;
	}
}
