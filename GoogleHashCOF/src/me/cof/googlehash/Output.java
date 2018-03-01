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
		this.filepath = filepath;
	}
	
	//Main file generator
	public void generateFile() {
		try {
            File file = new File("examples/output.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter writer = new FileWriter(file);
            
            for (int i = 0; i > vehicles.size(); i++) {
            	String data = "";
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
