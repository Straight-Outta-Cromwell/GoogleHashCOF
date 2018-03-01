package me.cof.googlehash;

import java.io.File;
import java.util.Scanner;

public class ReadFile {

	public static void pizzaArray() {
		Scanner file = null;
		char[][] cells;

		try {
			file = new Scanner(new File("input/example.in"));
		} catch (Exception e) {
			System.exit(0);
		}

		String line = file.nextLine();
		String[] properties = line.split(" ");
		System.out.println(properties.length);
		
		cells = new char[Integer.parseInt(properties[0])][Integer.parseInt(properties[1])];
		
		int count = 0;
		while (file.hasNextLine()){
			char[] temp = file.nextLine().toCharArray();
			//System.out.println(temp);
			for (int i = 0; i < Integer.parseInt(properties[1]); i++){
				cells[count][i] = temp[i];
			}
			count++;
		}

		for (int w = 0; w < Integer.parseInt(properties[0]); w++) {
			for (int h = 0; h < Integer.parseInt(properties[1]); h++) {
				System.out.print(cells[w][h]);
			}
			System.out.print("\n");
		}

		// String st = in.nextLine();
		// Scanner scan = new Scanner(st);
		//
		// int row = scan.nextInt();
		//
		// int column = scan.nextInt();
		// int min = scan.nextInt();
		//
		// char[][] pizza = new char[row][column];
		// String top = scan.next();
		// int max = top.charAt(0);
		//
		//
		// int count = 0;
		// for(int r = 0; r < row; r++) {
		// for(int c =0; c <column; c++) {
		//
		// pizza[r][c] = top.charAt(top.length() - 1);
		// System.out.print(pizza[r][c]);
		// count++;
		//
		// }
		//
		// }
		// scan.close();
		// in.close();
		//
	}

}
