/**
 * 
 */
package project6;

import java.util.Scanner;
import java.io.*;

/**
 * Program3.java
 * 
 * This program will accept an integer between 0 and 9, and search the text file
 * "countDigits.txt", printing the number of instances that integer appears in
 * the text file.
 * 
 * @author Emmet Stanevich
 *
 *         Created: 03-15-2018
 *
 */
public class Program3 {
	String fileIn = "countDigits.txt";
	String storage = null;
	int target = 0;
	int placeHolder = 0;
	int count = 0;

	/*
	 * Searches the text file for instances of the targeted integer between 0 and 9
	 * 
	 * @param x The integer to search for
	 */
	public Program3(int x) {
		target = x;
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream("countDigits.txt"));
			// placeHolder=input.nextInt();
			storage = input.nextLine();
			System.out.println(search(storage.length() - 1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Returns the number of times the target digit appears in the text file
	 * 
	 * @param x The digit to keep count of
	 */
	private int search(int x) {
		if (x == 0) {
			if (Integer.parseInt(storage.substring(x, x + 1)) == target)
				return 1;
			else
				return 0;
		} else {
			if (Integer.parseInt(storage.substring(x, x + 1)) == target)
				return 1 + search(x - 1);
			else
				return search(x - 1);
		}
	}
}
