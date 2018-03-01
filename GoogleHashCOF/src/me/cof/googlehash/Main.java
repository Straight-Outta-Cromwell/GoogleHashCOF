package me.cof.googlehash;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i <100; i++) {
			System.out.print(i);
		}
		
		Pizza pizza = new Pizza(null); //TODO Add file path
		
		//For loop for parsing through the X & Y coordinates of the array
		for (int x = 0; x < pizza.getWidth() ; x++) {
			for (int y = 0; y < pizza.getHeight() ; y++) {
				
				System.out.print(x + "-" + y); //Temp
			}
		}
	}
}
