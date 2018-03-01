package me.cof.googlehash;

public class Main {

	public static void main(String[] args) {
		
		Pizza pizza = new Pizza(null);
		
		for (int x = 0; x < pizza.getWidth() ; x++) {
			for (int y = 0; y < pizza.getHeight() ; y++) {
				
				System.out.print(x + "-" + y);
			}
		}
	}
}
