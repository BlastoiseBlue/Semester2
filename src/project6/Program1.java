/*
 * Program1.java
 * 
 * This program will infer the number of blocks in a pyramid made in a text file
 * based on how many rows the text file has
 * 
 * Created: March 3 2018
 * @author Emmet Stanevich
 */
package project6;

import java.io.*;
import java.util.Scanner;

public class Program1 {
	private String fileIn = "pyramid.txt";

	public Program1() {
		Scanner lineCounter = null;
		try {
			lineCounter = new Scanner(new FileInputStream(fileIn));
			System.out.println(count(countRows(lineCounter)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Looks at the input. If there is a next line, it increments the total by 1.
	 * Otherwise, it simply returns 1.
	 * 
	 * @param s The input
	 */
	private int countRows(Scanner s) {
		// int prev=0;
		if (s.hasNextLine()) {
			@SuppressWarnings("unused")
			String placeholder = s.nextLine();
			int prev = countRows(s);

			return prev + 1;
		} else
			return 0;
	}

	/*
	 * Returns the number of blocks in the pyramid, based on how many rows there are
	 * 
	 * @param rows The number of rows in the pyramid
	 */
	private int count(int rows) {
		if (rows == 1)
			return 1;
		else
			return count(rows - 1) + rows;
	}
	// public static void main(String[] args) {
	//
	// }

}
