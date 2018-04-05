/**
 * 
 */
package project6;

import java.util.Scanner;
import java.io.*;

/**
 * Program2.java
 * 
 * This program will read the specified text file and prints out the number of times the word "the" appears wihin it
 * 
 * @author Emmet Stanevich
 *
 *         Created: 03-15-2018
 *
 */
public class Program2 {
	String fileIn = "countSubString.txt";
	String storage = null;
	String target = null;

	public Program2(String s) {
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream(fileIn));
			storage = input.nextLine();
			target = s;
			System.out.println(find(storage.length() - target.length()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Finds the number of occurrences of the targeted word
	 * 
	 * @param x The place for the method to start looking
	 */
	private int find(int x) {
		if (x == 0) {
			if (storage.substring(x, x + target.length()).equalsIgnoreCase(target))
				return 1;
			else
				return 0;
		} else {
			if (storage.substring(x, x + target.length()).equalsIgnoreCase(target))
				return 1 + find(x - 1);
			else
				return find(x - 1);
		}

	}
}
