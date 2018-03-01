package me.cof.googlehash;

import java.io.File;
import java.util.Scanner;

public class ReadFile {

	public static char[][] pizzaArray(String filePath) {
		Scanner file = null;
		char[][] cells;

		try {
			file = new Scanner(new File(filePath));
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

//		for (int w = 0; w < Integer.parseInt(properties[0]); w++) {
//			for (int h = 0; h < Integer.parseInt(properties[1]); h++) {
//				System.out.print(cells[w][h]);
//			}
//			System.out.print("\n");
//		}
		
		return cells;
	}

}
