package me.cof.googlehash;

import java.io.File;
import java.util.Scanner;

public class ReadFile {
	
	public void pizzaArray(){
		Scanner in = null;
		//char[][] pizza
		
		try {
			in = new Scanner(new File("C:\\Users\\Chris\\Downloads\\example (1).in"));
		} catch (Exception e) {
			System.exit(0);
		}
		
		String st = in.nextLine();
		Scanner scan = new Scanner(st);
		
		int row = scan.nextInt();
		
		int column = scan.nextInt();
		int min = scan.nextInt();
		
		char[][] pizza = new char[row][column];
		String top = scan.next();
		//top.substring(0, 6)
		
		
		int count = 0;
		for(int r = 0; r < row; r++) {
			for(int c =0; c <column; c++) {
				
				pizza[r][c] = top.charAt(top.length() - 1);
				System.out.print(pizza[r][c]);
				count++;
				
			}
			
		}
		scan.close();
		in.close();
		
	}
	
	
	

}
