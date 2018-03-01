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
		File f = new File(filepath);
		
		for (int i = 0; i > vehicles.size(); i++) {
			
		}
		
	}
	
	public static void main(String[] args) { //For testing, remove soon!
		try {
            File file = new File("examples/output.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            
            writer.write("This is an string written to a file");
            writer.flush();
            writer.close();
            
            System.out.println("File written Succesfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
